package com.philosopherzb.health.check.kafka;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author philosopherZB
 * @date 2022/3/22
 */
@Data
@ConfigurationProperties(prefix = "health.check.kafka")
public class KafkaHealthProperties {
    /**
     * 是否启动kafka健康监测
     * 可选值：true & false
     * 默认 false
     */
    private String enabled = "false";
    /**
     * kafka 服务地址，此参数必填
     * 格式：master:9092,slave01:9092,slave02:9092
     */
    private String serverAddress;
    /**
     * kafka topic name，必须存在，否则将无法发送消息至主题或从主题消费消息
     * 格式：{project-name}-health-check-topic
     */
    private String topic = "kafka-default-health-check-topic";
    /**
     * 等待发送及消费的超时时长
     * 单位：毫秒
     * 默认 1500ms
     */
    private long sendAndReceiveTimeout = 1500L;
    /**
     * 从指定主题拉取消息的时长
     * 单位：毫秒
     * 默认 200ms
     */
    private long pollTimeout = 200L;

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
