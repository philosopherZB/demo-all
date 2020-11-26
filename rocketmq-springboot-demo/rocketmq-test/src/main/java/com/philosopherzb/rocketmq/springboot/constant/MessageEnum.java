package com.philosopherzb.rocketmq.springboot.constant;

import lombok.Getter;

/**
 * author: philosopherZB
 * date: 2020/11/26
 */
@Getter
public enum MessageEnum {

    /**
     * 测试
     */
    TEST("TEST", 0, "测试");

    /**
     * 枚举code
     */
    private String code;
    /**
     * 枚举值
     */
    private Integer value;
    /**
     * 枚举说明
     */
    private String desc;

    /**
     * 构造器
     *
     * @param code  枚举code
     * @param value 枚举value
     * @param desc  枚举说明
     */
    MessageEnum(String code, Integer value, String desc) {
        this.code = code;
        this.value = value;
        this.desc = desc;
    }
}
