package com.philosopherzb.springkafka.producer.service.impl;

import com.philosopherzb.springkafka.common.util.UUIDUtils;
import com.philosopherzb.springkafka.producer.config.ProducerTopicConfig;
import com.philosopherzb.springkafka.producer.domain.KafkaMessage;
import com.philosopherzb.springkafka.producer.service.SendMsgService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaFailureCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author philosopherZB
 * @date 2021/4/21
 */
@Slf4j
public abstract class AbstractSendMsgServiceImpl implements SendMsgService {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;
    @Resource
    private ProducerTopicConfig producerTopicConfig;

    @Override
    public boolean syncSend(KafkaMessage message) {
        ProducerRecord<String, String> record = createRecord(message);
        log.info("AbstractSendMsgServiceImpl.syncSend record:{}", record.toString());
        message.setKey(record.key());
        try {
            kafkaTemplate.send(record).get();
            onSendSuccess(message);
        } catch (ExecutionException | InterruptedException e) {
            log.error("AbstractSendMsgServiceImpl.syncSend occur exception, e:", e);
            onSendFail(message, e.getLocalizedMessage());
            return false;
        } catch (KafkaException e) {
            log.error("AbstractSendMsgServiceImpl.syncSend occur KafkaException, e:", e);
            onSendFail(message, e.getLocalizedMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean syncSendForTimeout(KafkaMessage message, long timeout, TimeUnit unit) {
        ProducerRecord<String, String> record = createRecord(message);
        log.info("AbstractSendMsgServiceImpl.syncSendForTimeout record:{}", record.toString());
        if (timeout <= 0 || unit == null) {
            timeout = 3;
            unit = TimeUnit.SECONDS;
        }

        message.setKey(record.key());
        try {
            kafkaTemplate.send(record).get(timeout, unit);
            onSendSuccess(message);
        } catch (ExecutionException | TimeoutException | InterruptedException e) {
            log.error("AbstractSendMsgServiceImpl.syncSendForTimeout occur exception, e:", e);
            onSendFail(message, e.getLocalizedMessage());
            return false;
        }
        return true;
    }


    @Override
    public void asyncSend(KafkaMessage message) {
        ProducerRecord<String, String> record = createRecord(message);
        log.info("AbstractSendMsgServiceImpl.asyncSend record:{}", record.toString());
        message.setKey(record.key());
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(record);
        future.addCallback(sendResult -> onSendSuccess(message),
                (KafkaFailureCallback<Integer, String>) ex -> {
                    log.error("AbstractSendMsgServiceImpl.asyncSend occur exception, e:", ex);
                    onSendFail(message, ex.getLocalizedMessage());
                });
    }

    /**
     * 发送成功，开放抽象接口供消息发送者使用
     *
     * @param message 消息体
     */
    protected abstract void onSendSuccess(KafkaMessage message);

    /**
     * 发送失败，开放抽象接口供消息发送者使用
     *
     * @param message  消息体
     * @param errorMsg 错误日志
     */
    protected abstract void onSendFail(KafkaMessage message, String errorMsg);

    /**
     * 创建发送记录
     *
     * @param message 消息
     * @return 将要发送的记录
     */
    private ProducerRecord<String, String> createRecord(KafkaMessage message) {
        String key = StringUtils.isBlank(message.getKey()) ? UUIDUtils.getUUID() : message.getKey();
        String topicKey = message.getTopic().getCode();
        Map<String, String> map = producerTopicConfig.getTopic();

        return new ProducerRecord<>(map.get(topicKey), key, message.getContent());
    }
}
