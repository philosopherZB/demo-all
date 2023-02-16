package com.philosopherzb.secret.service.gateway.interceptor;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.philosopherzb.secret.service.common.util.RSAUtils;
import com.philosopherzb.secret.service.gateway.vo.RsaVO;
import com.philosopherzb.secret.service.service.SecretService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.TreeMap;

/**
 * @author philosopherZB
 * @date 2022/2/8
 */
@Component
@Slf4j
public class SignInterceptor extends HandlerInterceptorAdapter {

    private static final String APP_ID = "appId";
    private static final String RANDOM_NUM = "randomNum";
    private static final String TIMESTAMP = "timestamp";
    private static final String SIGN = "sign";
    private static final long TIME_DURATION = 15 * 60 * 1000L;

    @Resource
    private SecretService secretService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String stream = readRequestStream(request);
        if (stream == null) {
            // todo 需替换
            throw new IllegalArgumentException("param error");
        }
        TreeMap<String, Object> streamMap = JSONUtil.toBean(stream, new TypeReference<TreeMap<String, Object>>() {
        }, Boolean.FALSE);
        // 校验
        checkParam(streamMap);

        return true;
    }

    /**
     * 读取流中数据
     *
     * @param request 请求
     * @return String
     */
    private String readRequestStream(HttpServletRequest request) {
        try {
            byte[] bytes = new byte[request.getContentLength()];
            InputStream is = request.getInputStream();
            for (int index = 0; index < request.getContentLength(); index++) {
                int value = is.read();
                if (value == -1) {
                    break;
                }
                bytes[index] = (byte) value;
            }
            return new String(bytes, StandardCharsets.UTF_8.toString());
        } catch (IOException e) {
            log.error("SignInterceptor readRequestStream occur exception, e:{}", e);
            return null;
        }
    }

    /**
     * 校验参数及签名
     */
    private void checkParam(TreeMap<String, Object> streamMap) {
        // 校验时间偏移量
        long inputTimestamp = Long.parseLong(checkAndGet(streamMap, TIMESTAMP));
        long timeOffset = inputTimestamp - System.currentTimeMillis();
        if (Math.abs(timeOffset) > TIME_DURATION) {
            log.error("SignInterceptor.checkParam timeOffset:{}, TIME_DURATION:{}", Math.abs(timeOffset), TIME_DURATION);
            // todo 需替换
            throw new IllegalArgumentException("timestamp offset is too big");
        }

        // 获取rsa
        String appId = checkAndGet(streamMap, APP_ID);
        RsaVO rsaVO = secretService.getByAppId(appId);

        // 校验随机码
        String randomNum = checkAndGet(streamMap, RANDOM_NUM);
        if (!randomNum.equals(rsaVO.getRandomNum())) {
            log.error("SignInterceptor.checkParam randomNum:{}", randomNum);
            // todo 需替换
            throw new IllegalArgumentException("invalid param randomNum: " + randomNum);
        }

        // 验签
        String sign = checkAndGet(streamMap, SIGN);
        try {
            // 验签时，需要移除sign字段
            streamMap.remove(SIGN);
            if (!RSAUtils.verify(streamMap.toString(), rsaVO.getAppPubKey(), sign)) {
                // todo 需替换
                throw new IllegalArgumentException("verify failure");
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException | SignatureException e) {
            log.error("SignInterceptor.checkParam RSAUtils.verify occur exception: ", e);
            // todo 需替换
            throw new IllegalArgumentException("verify failure");
        }
    }

    /**
     * 检查并获取指定参数
     *
     * @param streamMap 请求流数据
     * @param paramKey  参数key
     * @return 参数key对应的值
     */
    private String checkAndGet(TreeMap<String, Object> streamMap, String paramKey) {
        if (streamMap == null) {
            // todo 需替换
            throw new IllegalArgumentException("covert request json failure");
        }
        // 获取参数
        String result = streamMap.get(paramKey) == null ? "" : streamMap.get(paramKey).toString();
        if (StringUtils.isEmpty(result)) {
            // todo 需替换
            log.error("SignInterceptor.checkAndGet failure, streamMap:{}", JSONUtil.toJsonStr(streamMap));
            throw new IllegalArgumentException("param missing: " + paramKey);
        }
        return result;
    }
}
