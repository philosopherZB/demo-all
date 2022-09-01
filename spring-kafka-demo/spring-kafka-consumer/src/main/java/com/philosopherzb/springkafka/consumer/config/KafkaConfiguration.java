package com.philosopherzb.springkafka.consumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.util.backoff.BackOff;
import org.springframework.util.backoff.FixedBackOff;

/**
 * @author philosopherZB
 * @date 2022/9/1
 */
@Slf4j
@Configuration
public class KafkaConfiguration {

    @Bean
    @Primary
    public ErrorHandler errorRetryHandler() {
        log.info("kafkaErrorHandler begin to Handle...");

        // 创建 FixedBackOff 对象,设置重试间隔 10秒 次数为 3次
//        BackOff backOff = new FixedBackOff(10 * 1000L, 3L);
        // 创建 FixedBackOff 对象,设置重试间隔 5秒，无限次重试
        // 无限次重试存在隐患，如果partition中出现错误，那么该partition后续消息将会被阻塞，无法消费
        BackOff backOff = new FixedBackOff(5 * 1000L, FixedBackOff.UNLIMITED_ATTEMPTS);
        // 创建 SeekToCurrentErrorHandler 对象
        return new SeekToCurrentErrorHandler(backOff);
    }
}
