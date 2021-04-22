package com.philosopherzb.springkafka.common.util;

import java.util.UUID;

/**
 * @author philosopherZB
 * @date 2021/4/21
 */
public class UUIDUtils {

    /**
     * 获取UUID值，已剔除中划线
     *
     * @return 已剔除中划线的UUID值
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
