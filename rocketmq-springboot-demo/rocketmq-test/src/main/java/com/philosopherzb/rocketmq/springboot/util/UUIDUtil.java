package com.philosopherzb.rocketmq.springboot.util;

import java.util.UUID;

/**
 * author: philosopherZB
 * date: 2020/11/26
 */
public class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
