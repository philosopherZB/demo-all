package com.philosopherzb.springkafka.producer.service.impl;

import com.philosopherzb.springkafka.common.constant.MessageEnum;
import com.philosopherzb.springkafka.domain.KafkaAbnormalMessage;
import com.philosopherzb.springkafka.mapper.KafkaAbnormalMessageMapper;
import com.philosopherzb.springkafka.producer.config.ProducerTopicConfig;
import com.philosopherzb.springkafka.producer.domain.KafkaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

/**
 * @author philosopherZB
 * @date 2021/4/21
 */
@Slf4j
@Service("SendMsgService")
public class SendMsgServiceImpl extends AbstractSendMsgServiceImpl {

    @Resource
    private KafkaAbnormalMessageMapper kafkaAbnormalMessageMapper;
    @Resource
    private ProducerTopicConfig producerTopicConfig;

    @Override
    protected void onSendSuccess(KafkaMessage message) {

    }

    @Override
    protected void onSendFail(KafkaMessage message, String errorMsg) {
        CompletableFuture.supplyAsync(() -> {
            KafkaAbnormalMessage sendFailMessage = new KafkaAbnormalMessage();
            sendFailMessage.setTopic(producerTopicConfig.getTopic().get(message.getTopic().getCode()));
            sendFailMessage.setMsgKey(message.getKey());
            sendFailMessage.setContent(message.getContent());
            sendFailMessage.setMsgType(MessageEnum.TEST.getCode());
            sendFailMessage.setErrorMsg(errorMsg);
            // 发送失败入库
            return kafkaAbnormalMessageMapper.insert(sendFailMessage);
        }).whenComplete((t, v) -> {
            if (t < 1) {
                log.error("SendMsgServiceImpl.onSendFail kafka message insert db error");
            } else if (v != null) {
                log.error("SendMsgServiceImpl.onSendFail kafka message insert db error:{}", v);
            }
        });
    }
}
