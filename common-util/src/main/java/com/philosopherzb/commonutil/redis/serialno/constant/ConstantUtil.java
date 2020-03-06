package com.philosopherzb.commonutil.redis.serialno.constant;


/**
 * author: philosopherZB
 * date: 2020/1/6
 * 常量类
 */
public class ConstantUtil {

    /**
     * 流水号缓存Key前缀
     */
    public static final String SERIAL_CACHE_PREFIX = "ORDER_NO_CACHE_";
    /**
     * 流水号yyyyMMdd前缀
     */
    public static final String SERIAL_YYYY_MM_DD_PREFIX = "yyyyMMddHHmmss";
    /**
     * 默认缓存天数
     */
    public static final int DEFAULT_CACHE_DAYS = 1;


}
