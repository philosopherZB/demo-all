package com.philosopherzb.springkafka.consumer.listener;

import com.philosopherzb.springkafka.common.constant.MessageEnum;
import com.philosopherzb.springkafka.consumer.config.ConsumerConfig;
import com.philosopherzb.springkafka.domain.KafkaAbnormalMessage;
import com.philosopherzb.springkafka.mapper.KafkaAbnormalMessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author philosopherZB
 * @date 2021/4/22
 */
@Slf4j
@Component
public class ReceiveMsgListener {

    @Resource
    private KafkaAbnormalMessageMapper kafkaAbnormalMessageMapper;
    @Resource
    private ConsumerConfig consumerConfig;

    @KafkaListener(id = "#{consumerConfig.ListenerId}", topics = "#{consumerConfig.testTopic}")
    public void listen(String data, ConsumerRecordMetadata recordMetadata, Acknowledgment ack,
                       @Header(name = KafkaHeaders.RECEIVED_MESSAGE_KEY, required = false) String key) {
        if (!handleMessage(data, recordMetadata, new AtomicInteger(consumerConfig.getRetries()), ack, key)) {
            log.error("ReceiveMsgListener.listen consume message failure, message:{}", data);
        }
    }

    /**
     * 处理消息
     *
     * @param data           payload
     * @param recordMetadata 元信息
     * @param retries        重试次数
     * @param ack            手动提交
     * @param key            messageKey
     * @return 处理结果
     */
    private boolean handleMessage(String data, ConsumerRecordMetadata recordMetadata, AtomicInteger retries, Acknowledgment ack, String key) {
        try {
            log.info("ReceiveMsgListener.handleMessage, receive msg:{}", data);
            log.info("ReceiveMsgListener.handleMessage, receive recordMetadata:{}", retries);
            // 业务处理成功，提交消费任务并返回
//            if (true) {
//                ack.acknowledge();
//                return true;
//            }
            // 达到重试次数仍未处理成功，则入库
            if (retries.getAndDecrement() <= 0) {
                consumeFailure(setAttribute(data, recordMetadata, key));
                return false;
            } else {
                handleMessage(data, recordMetadata, retries, ack, key);
            }
            return false;
        } catch (Exception e) {
            log.error("ReceiveMsgListener.handleMessage occur exception, message:{}, e:{}", data, e);
            return false;
        }
    }

    /**
     * 失败入库
     *
     * @param consumeFailMessage 失败消息
     */
    private void consumeFailure(KafkaAbnormalMessage consumeFailMessage) {
        CompletableFuture.supplyAsync(() -> {
            // 失败入库
            return kafkaAbnormalMessageMapper.insert(consumeFailMessage);
        }).whenComplete((t, v) -> {
            if (t < 1) {
                log.error("ReceiveMsgListener.consumeFailure kafka message insert db error");
            } else if (v != null) {
                log.error("ReceiveMsgListener.consumeFailure kafka message insert db error:{}", v);
            }
        });
    }

    /**
     * 设置消息属性
     *
     * @param data           接收到的消息体
     * @param recordMetadata 接收到记录元信息
     * @param key            messageKey
     * @return 设置完属性之后的KafkaAbnormalMessage
     */
    private KafkaAbnormalMessage setAttribute(String data, ConsumerRecordMetadata recordMetadata, String key) {
        KafkaAbnormalMessage consumeFailMessage = new KafkaAbnormalMessage();
        consumeFailMessage.setTopic(recordMetadata.topic());
        consumeFailMessage.setMsgPartition(recordMetadata.partition());
        consumeFailMessage.setGroupId(recordMetadata.topic());
        consumeFailMessage.setMsgKey(key);
        consumeFailMessage.setContent(data);
        consumeFailMessage.setMsgType(MessageEnum.TEST.getCode());
        consumeFailMessage.setRetryCount(consumerConfig.getRetries());
        consumeFailMessage.setErrorMsg("consume " + recordMetadata.topic() + "failure");
        return consumeFailMessage;
    }
}
