package com.philosopherzb.springkafka.consumer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author philosopherZB
 * @date 2021/4/21
 */
@Configuration
@ConfigurationProperties(prefix = "config")
@Data
public class ConsumerConfig {

    /**
     * 需要进行消费的 testTopic
     */
    private String testTopic;
    /**
     * 需要进行消费的 demoTopic
     */
    private String demoTopic;

    /**
     * 监听器id
     */
    private String ListenerId;

    /**
     * 消费者重试次数
     */
    private Integer retries;
}
