package com.philosopherzb.secret.sdk;

import com.philosopherzb.secret.sdk.util.DasLogger;
import com.philosopherzb.secret.sdk.util.DasUtils;
import com.philosopherzb.secret.sdk.util.NamedThreadFactory;
import com.philosopherzb.secret.sdk.util.WebUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author philosopherZB
 * @date 2022/1/17
 */
class SecurityHandler {
    private static AtomicBoolean initThreadPoolAtomic = new AtomicBoolean(false);
    private static ExecutorService executorService;
    private DefaultSecurityClient securityClient;
    private static final ConcurrentHashMap<String, SecurityContext> allAppConfig = new ConcurrentHashMap<>();
    private static final Map<String, SecurityContext> appLocalSecretCache = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Object> asyncQueueKey = new ConcurrentHashMap<>();
    private static final Object emptyValue = new Object();
    private static final long dayMillis = 24 * 60 * 60 * 1000;

    SecurityHandler(DefaultSecurityClient securityClient, int corePoolSize, int maxPoolSize, int maxQueue) {
        this.securityClient = securityClient;
        init(corePoolSize, maxPoolSize, maxQueue);
    }

    /**
     * 获取压缩长度
     *
     * @return 压缩长度
     */
    int getCompressLen() {
        SecurityContext securityContext = getAppConfig();
        if (securityContext != null && securityContext.getEncryptIndexCompressLen() != null) {
            return securityContext.getEncryptIndexCompressLen();
        }
        return SecurityConstants.DEFAULT_INDEX_ENCRYPT_COMPRESS_LEN;
    }

    /**
     * 获取滑动窗口大小
     *
     * @return 滑动窗口大小
     */
    int getSlideSize() {
        SecurityContext securityContext = getAppConfig();
        if (securityContext != null && securityContext.getEncryptSlideSize() != null) {
            return securityContext.getEncryptSlideSize();
        }
        return SecurityConstants.DEFAULT_ENCRYPT_SLIDE_SIZE;
    }

    /**
     * 获取秘钥
     *
     * @param secretVersion 秘钥版本
     * @return 秘钥上下文
     */
    SecurityContext getSecret(Long secretVersion) throws DasSecurityException {
        SecurityContext secretContext = appLocalSecretCache.get(generateCacheKey(secretVersion));
        if (secretContext != null) {
            if (secretContext.isValid()) {
                return secretContext;
            }

            if (secretContext.isMaxValid()) {
                // 异步更新秘钥
                asyncUpdateSecret(secretVersion);
                return secretContext;
            }
            String cacheKey = generateCacheKey(secretVersion);
            appLocalSecretCache.remove(cacheKey);
            // 同步调用获取秘钥
            return callSecretApi(secretVersion);
        } else {
            // 同步调用获取秘钥
            return callSecretApi(secretVersion);
        }
    }

    /**
     * @return SecurityContext
     */
    private SecurityContext getAppConfig() {
        return allAppConfig.get(securityClient.getAppId());
    }

    /**
     * 初始化线程池
     *
     * @param corePoolSize 核心线程数
     * @param maxPoolSize  最大线程数
     * @param maxQueue     队列长度
     */
    private void init(int corePoolSize, int maxPoolSize, int maxQueue) {
        if (corePoolSize <= 0 || maxPoolSize <= 0 || maxQueue <= 0 || corePoolSize > maxPoolSize) {
            throw new IllegalArgumentException("param error");
        }
        if (initThreadPoolAtomic.compareAndSet(false, true)) {
            executorService = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(maxQueue), new NamedThreadFactory("das sdk async update secret", true),
                    new ThreadPoolExecutor.AbortPolicy());
        }
    }

    private String generateCacheKey(Long secretVersion) {
        return securityClient.getAppId() + "_" + secretVersion;
    }

    /**
     * 异步更新秘钥
     *
     * @param secretVersion 秘钥版本
     */
    private void asyncUpdateSecret(final Long secretVersion) {
        final String cacheKey = generateCacheKey(secretVersion);
        try {
            synchronized (SecurityHandler.class) {
                // 不需要重复提交秘钥请求
                if (asyncQueueKey.containsKey(cacheKey)) {
                    return;
                }

                // 本地存在
                SecurityContext localSecurityContext = appLocalSecretCache.get(cacheKey);
                if (localSecurityContext != null && localSecurityContext.isValid()) {
                    return;
                }
                asyncQueueKey.put(cacheKey, emptyValue);
            }

            CompletableFuture.supplyAsync(() -> {
                try {
                    return callSecretApi(secretVersion);
                } catch (DasSecurityException e) {
                    DasLogger.logBizDebug(e);
                    asyncQueueKey.remove(cacheKey);
                    return e;
                }
            }, executorService)
                    .whenComplete((r, throwable) -> {
                        if (throwable != null) {
                            DasLogger.logBizDebug(throwable);
                            asyncQueueKey.remove(cacheKey);
                        }
                    });
        } catch (RuntimeException e) {
            // 可能会抛出RejectedExecutionException 、NullPointerException等异常
            asyncQueueKey.remove(cacheKey);
            throw e;
        }
    }

    /**
     * api 获取秘钥
     *
     * @param secretVersion 秘钥版本
     * @return 秘钥上下文
     */
    private SecurityContext callSecretApi(Long secretVersion) throws DasSecurityException {
        // todo 处理包装体
        String result = doPost(secretVersion);
        JSONObject jsonObject = new JSONObject(result);
        // 处理结果验签
        if (securityClient.isVerifyResponse() && !checkResponseSign(jsonObject)) {
            throw new DasSecurityException("response verify failure");
        }

        SecurityContext securityContext = new SecurityContext();
        securityContext.setSecretVersion(secretVersion);
        securityContext.setInvalidTime(System.currentTimeMillis() + jsonObject.getInt(SecurityConstants.RESPONSE_INVALID_TIME) * dayMillis);
        securityContext.setMaxInvalidTime(System.currentTimeMillis() + jsonObject.getInt(SecurityConstants.RESPONSE_MAX_INVALID_TIME) * dayMillis);
        // 如果滑动窗口存在，则取云端数据
        securityContext.setEncryptSlideSize(jsonObject.getInt(SecurityConstants.RESPONSE_ENCRYPT_SLIDE_SIZE));
        securityContext.setEncryptIndexCompressLen(jsonObject.getInt(SecurityConstants.RESPONSE_ENCRYPT_INDEX_COMPRESS_LEN));
        // 获取secret
        String aesKey = jsonObject.getString(SecurityConstants.RESPONSE_AES_KEY);
        String decryptAesKey = DasUtils.rsaDecrypt(aesKey, securityClient.getPrivateKey());
        securityContext.setSecret(decryptAesKey.getBytes(StandardCharsets.UTF_8));

        allAppConfig.put(securityClient.getAppId(), securityContext);
        appLocalSecretCache.put(generateCacheKey(secretVersion), securityContext);
        return securityContext;
    }

    private String doPost(Long secretVersion) throws DasSecurityException {
        // 1. 公共参数
        Map<String, Object> params = new TreeMap<>();
        params.put(SecurityConstants.APP_ID, securityClient.getAppId());
        params.put(SecurityConstants.RANDOM_NUM, securityClient.getRandomNum());
        params.put(SecurityConstants.TIMESTAMP, System.currentTimeMillis());
        params.put(SecurityConstants.CHARSET, securityClient.getCharset());

        // 2. 业务参数
        Map<String, Object> bizParams = new HashMap<>(2);
        bizParams.put(SecurityConstants.SECRET_VERSION, secretVersion);
        bizParams.put(SecurityConstants.VERITY_RESPONSE, securityClient.isVerifyResponse());

        try {
            // 3. 设置业务参数
            params.put(SecurityConstants.BIZ_CONTENT_KEY, new JSONObject(bizParams).toString());

            // 4. 计算签名并设置
            String sign = DasUtils.rsaSign(params.toString(), securityClient.getPrivateKey());
            params.put(SecurityConstants.SIGN, sign);

            // 5. call api
            String requestParam = new JSONObject(params).toString();
            DasLogger.logBizDebug(requestParam);

            String result =  WebUtils.doPost(securityClient.getServerUrl() + SecurityConstants.API_SECURITY_GET_SECRET_KEY_URL,
                    requestParam, securityClient.getCharset(),
                    securityClient.getConnectTimeout(), securityClient.getReadTimeout());
            DasLogger.logBizDebug(result);
            return result;
        } catch (IOException e) {
            throw new DasSecurityException(e);
        }
    }

    /**
     * 检查响应签名
     *
     * @param jsonObject 响应json
     * @return 检查结果
     * @throws DasSecurityException DasSecurityException
     */
    private boolean checkResponseSign(JSONObject jsonObject) throws DasSecurityException {
        Map<String, Object> treeMap = new TreeMap<>();
        treeMap.put(SecurityConstants.APP_ID, jsonObject.getString(SecurityConstants.APP_ID));
        treeMap.put(SecurityConstants.RESPONSE_AES_KEY, jsonObject.getString(SecurityConstants.RESPONSE_AES_KEY));
        treeMap.put(SecurityConstants.RESPONSE_INVALID_TIME, jsonObject.getInt(SecurityConstants.RESPONSE_INVALID_TIME));
        treeMap.put(SecurityConstants.RESPONSE_MAX_INVALID_TIME, jsonObject.getInt(SecurityConstants.RESPONSE_MAX_INVALID_TIME));
        treeMap.put(SecurityConstants.RESPONSE_ENCRYPT_INDEX_COMPRESS_LEN, jsonObject.getInt(SecurityConstants.RESPONSE_ENCRYPT_INDEX_COMPRESS_LEN));
        treeMap.put(SecurityConstants.RESPONSE_ENCRYPT_SLIDE_SIZE, jsonObject.getInt(SecurityConstants.RESPONSE_ENCRYPT_SLIDE_SIZE));

        String responseSign = jsonObject.getString(SecurityConstants.RESPONSE_SIGN);
        return DasUtils.rsaVerify(treeMap.toString(), securityClient.getDasPublicKey(), responseSign);
    }
}
