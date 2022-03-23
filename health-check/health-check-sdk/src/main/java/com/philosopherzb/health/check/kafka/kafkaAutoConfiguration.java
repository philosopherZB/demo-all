package com.philosopherzb.health.check.kafka;

import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @author philosopherZB
 * @date 2022/3/22
 */
@EnableConfigurationProperties(KafkaHealthProperties.class)
@ConditionalOnProperty(prefix = "health.check.kafka", value = "enabled", havingValue = "true")
public class kafkaAutoConfiguration {

    @Resource
    private KafkaHealthProperties kafkaHealthProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledHealthIndicator("kafka")
    public KafkaHealthIndicator kafkaHealthIndicator() {
        return new KafkaHealthIndicator(kafkaHealthProperties);
    }
}
