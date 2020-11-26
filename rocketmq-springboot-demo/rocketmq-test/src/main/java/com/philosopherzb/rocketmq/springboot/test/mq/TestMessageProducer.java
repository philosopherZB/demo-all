package com.philosopherzb.rocketmq.springboot.test.mq;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.bean.ProducerBean;
import com.philosopherzb.rocketmq.springboot.domain.MqAbnormalMessage;
import com.philosopherzb.rocketmq.springboot.produce.impl.AbstractMessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

/**
 * author: philosopherZB
 * date: 2020/11/19
 */
@Slf4j
@Component("defaultMessageProducer")
public class TestMessageProducer extends AbstractMessageProducer {

    @Autowired
    public TestMessageProducer(ProducerBean producerBean) {
        super(producerBean);
    }

    @Override
    protected void onSendSuccess(Message message) {

    }

    @Override
    protected void onSendFail(Message message, String errorMsg) {
        CompletableFuture.supplyAsync(() -> {
            MqAbnormalMessage sendFailMessage = new MqAbnormalMessage();
            sendFailMessage.setId(1L);
            sendFailMessage.setTopic(message.getTopic());
            sendFailMessage.setGroup("groupId");
            sendFailMessage.setTag(message.getTag());
            sendFailMessage.setKey(message.getKey());
            sendFailMessage.setType("type");
            sendFailMessage.setUserProperties(message.getUserProperties() == null ? "null" : message.getUserProperties().toString());
            sendFailMessage.setMessageId(message.getMsgID());
            sendFailMessage.setRetryTime(message.getReconsumeTimes());
            sendFailMessage.setBody(new String(message.getBody(), StandardCharsets.UTF_8));
            sendFailMessage.setErrorMsg("send message fail");
            // 发送失败入库
//            return unconsumedMessageMapper.save(sendFailMessage);
            return 1;
        }).whenComplete((t, v) -> {
            if (t < 1) {
                log.info("test message insert db error");
            } else if (v != null) {
                log.info("test message insert db error:{}", v);
            }
        });
    }
}
