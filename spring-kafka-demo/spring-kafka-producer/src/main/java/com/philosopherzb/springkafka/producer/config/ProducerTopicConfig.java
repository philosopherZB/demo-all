package com.philosopherzb.springkafka.producer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

/**
 * @author philosopherZB
 * @date 2021/4/21
 */
@Configuration
@ConfigurationProperties(prefix = "config")
// 只有一个主属性文件时，可以忽略此配置
@PropertySource("classpath:application.properties")
@Data
public class ProducerTopicConfig {

    /**
     * 需要发送消息至对应的topics
     */
    private Map<String, String> topic;
}
