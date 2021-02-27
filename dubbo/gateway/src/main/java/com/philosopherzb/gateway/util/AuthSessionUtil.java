package com.philosopherzb.gateway.util;

import java.util.Map;

/**
 * author: philosopherZB
 * date: 2021/2/27
 */
public class AuthSessionUtil {
    private static final ThreadLocal<Map<String, String>> sessionThreadLocal = new ThreadLocal<>();

    /**
     * 设置threadLocal
     *
     * @param map 设置值
     */
    public static void setSessionThreadLocal(Map<String, String> map) {
        sessionThreadLocal.set(map);
    }

    /**
     * 获取threadLocal中的值
     *
     * @param key 指定key
     * @return 对应的认证信息
     */
    public static String getAuthInfo(String key) {
        Map<String, String> map = sessionThreadLocal.get();
        return map.get(key);
    }

    /**
     * 清除threadLocal
     */
    public static void clear() {
        sessionThreadLocal.remove();
    }
}
