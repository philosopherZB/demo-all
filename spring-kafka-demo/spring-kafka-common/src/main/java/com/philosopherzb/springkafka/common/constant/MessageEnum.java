package com.philosopherzb.springkafka.common.constant;

import lombok.Getter;

/**
 * @author philosopherZB
 * @date 2020/04/21
 */
@Getter
public enum MessageEnum {

    /**
     * 测试
     */
    TEST("TEST", 0, "测试消息"),
    DEMO("DEMO", 1, "样例消息");;

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
