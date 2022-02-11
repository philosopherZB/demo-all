package com.philosopherzb.secret.sdk;

import com.philosopherzb.secret.sdk.util.DasUtils;
import com.philosopherzb.secret.sdk.util.InternalStringUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 加解密客户端，初始化一个即可（单例模式）
 *
 * @author philosopherZB
 * @date 2022/1/17
 */
public class DefaultSecurityClient implements SecurityClient {

    private String serverUrl;
    private String appId;
    private String privateKey;
    /**
     * 应用公钥
     */
    private String dasPublicKey;
    /**
     * 伪随机码
     */
    private String randomNum;

    private String charset = StandardCharsets.UTF_8.name();
    private int connectTimeout = 15000;
    private int readTimeout = 30000;

    /**
     * 是否对响应结果进行验签
     */
    private boolean verifyResponse = false;
    /**
     * 秘钥核心处理类
     */
    private SecurityHandler securityHandler;

    public DefaultSecurityClient(String serverUrl, String appId, String privateKey, String randomNum) {
        this.serverUrl = serverUrl;
        this.appId = appId;
        this.privateKey = privateKey;
        this.randomNum = randomNum;
        // 初始化处理器
        int corPoolSize = 1;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int maxPoolSize = availableProcessors <= corPoolSize ? corPoolSize + 1 : availableProcessors;
        securityHandler = new SecurityHandler(this, corPoolSize, maxPoolSize, Integer.MAX_VALUE);
    }

    public DefaultSecurityClient(String serverUrl, String appId, String privateKey,
                                 String randomNum, String dasPublicKey) {
        this(serverUrl, appId, privateKey, randomNum);
        this.dasPublicKey = dasPublicKey;
        // 存在dasPublicKey，说明需要对结果进行验签
        this.verifyResponse = true;
    }

    public DefaultSecurityClient(String serverUrl, String appId, String privateKey,
                                 String randomNum, String dasPublicKey, String charset) {
        this(serverUrl, appId, privateKey, randomNum, dasPublicKey);
        this.charset = charset;
    }

    public DefaultSecurityClient(String serverUrl, String appId, String privateKey, String randomNum,
                                 String dasPublicKey, String charset, int connectTimeout, int readTimeout) {
        this(serverUrl, appId, privateKey, randomNum, dasPublicKey, charset);
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }

    @Override
    public boolean isEncryptData(String data, String type) throws DasSecurityException {
        return SecurityManager.isEncryptData(data, type);
    }

    @Override
    public boolean isEncryptDataForList(List<String> dataList, String type) throws DasSecurityException {
        if (dataList == null || dataList.isEmpty()) {
            return false;
        }
        for (String data : dataList) {
            if (!isEncryptData(data, type)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEitherEncryptDataForList(List<String> dataList, String type) throws DasSecurityException {
        if (dataList == null || dataList.isEmpty()) {
            return false;
        }
        for (String data : dataList) {
            if (isEncryptData(data, type)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String encrypt(String data, String type, Long version) throws DasSecurityException {
        if (InternalStringUtils.isBlank(data)) {
            return data;
        }
        if (version == null) {
            throw new DasSecurityException("version is null");
        }
        try {
            SecurityContext secretContext = securityHandler.getSecret(version);
            if (secretContext == null || secretContext.getSecret() == null) {
                throw new DasSecurityException("secretContext is null");
            }

            // 获取分隔符
            String separator = SecurityManager.getSeparatorMap().get(type);
            if (separator == null) {
                throw new DasSecurityException("type not exist");
            }

            // 手机号类型, id类型，即有规律的数字，例如身份证
            if (SecurityConstants.TYPE_PHONE.equals(type) || SecurityConstants.TYPE_ID.equals(type)) {
                return SecurityManager.encryptPhoneOrId(data, separator, secretContext);
            }
            // 支持模糊搜索的文本类型
            if (SecurityConstants.TYPE_SEARCH.equals(type)) {
                int compressLen = securityHandler.getCompressLen();
                int slideSize = securityHandler.getSlideSize();
                return SecurityManager.encryptSearch(data, compressLen, slideSize, separator, secretContext);
            }
            // 普通文本类型
            if (SecurityConstants.TYPE_SIMPLE.equals(type)) {
                return SecurityManager.encryptSimple(data, separator, secretContext);
            }

            // 加密类型不匹配
            throw new DasSecurityException("encrypt type mismatch");
        } catch (Exception e) {
            throw new DasSecurityException("encrypt error", e);
        }
    }

    @Override
    public Map<String, String> encryptForBatch(List<String> dataList, String type, Long version) throws DasSecurityException {
        if (dataList == null || dataList.isEmpty()) {
            throw new DasSecurityException("dataList can`t be empty");
        }
        if (version == null) {
            throw new DasSecurityException("version is null");
        }
        Map<String, String> resultMap = new HashMap<>();
        for (String data : dataList) {
            if (!resultMap.containsKey(data)) {
                String encryptValue = encrypt(data, type, version);
                resultMap.put(data, encryptValue);
            }
        }
        return resultMap;
    }

    @Override
    public String decrypt(String data, String type, Long version) throws DasSecurityException {
        if (InternalStringUtils.isBlank(data) || data.length() < 4) {
            return data;
        }
        if (version == null) {
            throw new DasSecurityException("version is null");
        }
        // 获取分隔符
        Character charValue = SecurityManager.getSeparatorCharMap().get(type);
        if (charValue == null) {
            throw new DasSecurityException("type not exist");
        }

        // 校验密文格式
        char separator = charValue;
        if (!(data.charAt(0) == separator && data.charAt(data.length() - 1) == separator)) {
            return data;
        }

        try {
            // 获取分隔后的密文对象
            SecurityData securityData;
            if (data.charAt(data.length() - 2) == separator) {
                securityData = SecurityManager.getIndexSecurityData(data, separator);
            } else {
                securityData = SecurityManager.getSecurityData(data, separator);
            }
            // 非法密文
            if (securityData == null) {
                return data;
            }

            SecurityContext secretContext = securityHandler.getSecret(version);
            if (secretContext == null || secretContext.getSecret() == null) {
                throw new DasSecurityException("secretContext is null");
            }
            return DasUtils.aesDecrypt(securityData.getEncryptValue(), secretContext.getSecret());
        } catch (Exception e) {
            throw new DasSecurityException("decrypt error", e);
        }
    }

    @Override
    public Map<String, String> decryptForBatch(List<String> dataList, String type, Long version) throws DasSecurityException {
        if (dataList == null || dataList.isEmpty()) {
            throw new DasSecurityException("dataList can`t be empty");
        }
        if (version == null) {
            throw new DasSecurityException("version is null");
        }
        Map<String, String> resultMap = new HashMap<>();
        for (String data : dataList) {
            if (!resultMap.containsKey(data)) {
                String decryptValue = decrypt(data, type, version);
                resultMap.put(data, decryptValue);
            }
        }
        return resultMap;
    }

    @Override
    public String search(String data, String type, Long version) throws DasSecurityException {
        if (InternalStringUtils.isBlank(data)) {
            return data;
        }
        if (version == null) {
            throw new DasSecurityException("version is null");
        }
        try {
            SecurityContext secretContext = securityHandler.getSecret(version);
            if (secretContext == null || secretContext.getSecret() == null) {
                throw new DasSecurityException("secretContext is null");
            }

            // 手机号类型, id类型，即有规律的数字，例如身份证
            if (SecurityConstants.TYPE_PHONE.equals(type) || SecurityConstants.TYPE_ID.equals(type)) {
                return SecurityManager.getForPhoneOrId(data, secretContext);
            }
            // 支持模糊搜索的文本类型
            if (SecurityConstants.TYPE_SEARCH.equals(type)) {
                int compressLen = securityHandler.getCompressLen();
                int slideSize = securityHandler.getSlideSize();
                return SecurityManager.getForSearch(data, compressLen, slideSize, secretContext);
            }

            // 加密类型不匹配
            throw new DasSecurityException("encrypt type mismatch");
        } catch (Exception e) {
            throw new DasSecurityException("search error", e);
        }
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getDasPublicKey() {
        return dasPublicKey;
    }

    public void setDasPublicKey(String dasPublicKey) {
        this.dasPublicKey = dasPublicKey;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public String getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(String randomNum) {
        this.randomNum = randomNum;
    }

    public boolean isVerifyResponse() {
        return verifyResponse;
    }

    public void setVerifyResponse(boolean verifyResponse) {
        this.verifyResponse = verifyResponse;
    }

    public static class Builder {
        private DefaultSecurityClient client;

        Builder(String serverUrl, String appId, String privateKey, String randomNum) {
            client = new DefaultSecurityClient(serverUrl, appId, privateKey, randomNum);
        }

        public DefaultSecurityClient build() {
            return client;
        }

        public Builder dasPublicKey(String dasPublicKey) {
            client.setDasPublicKey(dasPublicKey);
            return this;
        }

        public Builder charset(String charset) {
            client.setCharset(charset);
            return this;
        }

        public Builder connectTimeout(int connectTimeout) {
            client.setConnectTimeout(connectTimeout);
            return this;
        }

        public Builder readTimeout(int readTimeout) {
            client.setReadTimeout(readTimeout);
            return this;
        }

        public Builder verifyResponse(boolean verifyResponse) {
            client.setVerifyResponse(verifyResponse);
            return this;
        }
    }

}
