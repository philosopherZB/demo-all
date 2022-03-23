package com.philosopherzb.health.check.rocketmq;

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
@EnableConfigurationProperties(RocketMQHealthProperties.class)
@ConditionalOnProperty(prefix = "health.check.rocketmq", value = "enabled", havingValue = "true")
public class RocketMQAutoConfiguration {

    @Resource
    private RocketMQHealthProperties rocketMQHealthProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledHealthIndicator("rocketmq")
    public RocketMQHealthIndicator rocketMQHealthIndicator() {
        return new RocketMQHealthIndicator(rocketMQHealthProperties);
    }
}
