package com.philosopherzb.springkafka.producer.constant;

import lombok.Getter;

/**
 * @author philosopherZB
 * @date 2021/4/21
 */
@Getter
public enum TopicEnum {
    /**
     * 测试
     */
    TEST("test", "测试0"),
    /**
     * 样例
     */
    DEMO("demo", "样例1"),
    ;

    /**
     * 枚举code,此值与application.properties文件中的值保持一致，eg：{config.topic.test = testTopic} 则code = test
     */
    private String code;
    /**
     * 枚举说明
     */
    private String desc;

    /**
     * 构造器
     *
     * @param code 枚举code
     * @param desc 枚举说明
     */
    TopicEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
