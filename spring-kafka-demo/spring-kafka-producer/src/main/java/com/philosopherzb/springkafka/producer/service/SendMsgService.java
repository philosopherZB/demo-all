package com.philosopherzb.springkafka.producer.service;


import com.philosopherzb.springkafka.producer.domain.KafkaMessage;

import java.util.concurrent.TimeUnit;

/**
 * @author philosopherZB
 * @date 2021/4/21
 */
public interface SendMsgService {

    /**
     * 阻塞获取同步消息
     *
     * @param message 消息体
     */
    boolean syncSend(KafkaMessage message);

    /**
     * 阻塞获取同步消息
     * 阻塞时长及单位未传输时，将会设置为timeout=3，unit=TimeUnit.SECONDS
     * 如果阻塞时长需要设置为0，请调用syncSend(KafkaMessage message)
     *
     * @param message 消息体
     * @param timeout 阻塞时长
     * @param unit    阻塞时长单位
     */
    boolean syncSendForTimeout(KafkaMessage message, long timeout, TimeUnit unit);

    /**
     * 异步消息
     *
     * @param message 消息体
     */
    void asyncSend(KafkaMessage message);
}
