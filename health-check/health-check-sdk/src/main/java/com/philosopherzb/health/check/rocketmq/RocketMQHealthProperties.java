package com.philosopherzb.health.check.rocketmq;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author philosopherZB
 * @date 2022/3/22
 */
@Data
@ConfigurationProperties(prefix = "health.check.rocketmq")
public class RocketMQHealthProperties {
    /**
     * 是否启动rocketmq健康监测
     * 可选值：true & false
     * 默认 false
     */
    private String enabled = "false";
    /**
     * rocketmq 服务地址，此参数必填
     * 格式：master:9876;slave01:9876;slave02:9876
     */
    private String serverAddress;
    /**
     * 以tag区分不同类型的消息
     * 格式：{project-name}-health-check-tag
     */
    private String tag = "rocketmq-default-health-check-tag";
    /**
     * 发送超时时长
     * 单位：毫秒
     * 默认 1500ms
     */
    private long sendTimeout = 1500L;

    /**
     * 消费者缓存消息的过期时间，用于校验与生产者的消息是否一致
     * 单位：分钟
     * 默认 10min
     */
    private int cacheMaxTime = 10;
    /**
     * 消费者缓存的消息条数，用于校验与生产者的消息是否一致
     * 默认 100条
     */
    private int cacheMaximumSize = 100;
}
