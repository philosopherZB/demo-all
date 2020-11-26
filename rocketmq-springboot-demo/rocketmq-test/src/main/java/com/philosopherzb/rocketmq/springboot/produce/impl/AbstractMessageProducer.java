package com.philosopherzb.rocketmq.springboot.produce.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.OnExceptionContext;
import com.aliyun.openservices.ons.api.SendCallback;
import com.aliyun.openservices.ons.api.SendResult;
import com.aliyun.openservices.ons.api.bean.ProducerBean;
import com.philosopherzb.rocketmq.springboot.produce.MessageProducer;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: philosopherZB
 * date: 2020/8/26
 */
@Slf4j
public abstract class AbstractMessageProducer implements MessageProducer {

    @Resource
    private ProducerBean producerBean;

    public AbstractMessageProducer(ProducerBean producerBean) {
        this.producerBean = producerBean;
    }

    @Override
    public void syncSend(Message message) {
        log.info("AbstractMessageProducer.syncSend, sync send mq message:{}", JSONObject.toJSONString(message));
        try {
            SendResult sendResult = producerBean.send(message);
            if (sendResult == null) {
                // send mq message fail
                onSendFail(message, null);
            } else {
                // send mq message success
                onSendSuccess(message);
            }

        } catch (Exception e) {
            log.info("AbstractMessageProducer.syncSend, sync send mq message occur exception:{}", e);
        }
    }

    @Override
    public void syncSendBatch(List<Message> messageList) {
        log.info("AbstractMessageProducer.syncSendBatch, sync send batch mq message:{}", JSONObject.toJSONString(messageList));
        for (Message message : messageList) {
            syncSend(message);
        }
    }

    @Override
    public void asyncSend(Message message) {
        log.info("AbstractMessageProducer.asyncSend, async send mq message:{}", JSONObject.toJSONString(message));
        producerBean.sendAsync(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                // send mq message success
                onSendSuccess(message);
            }

            @Override
            public void onException(OnExceptionContext onExceptionContext) {
                // send mq message fail
                onSendFail(message, onExceptionContext.getException().getMessage());
            }
        });
    }

    @Override
    public void syncDelaySend(Message message, long deliverTime) {
        log.info("AbstractMessageProducer.syncDelaySend, sync delay send mq message:{}", JSONObject.toJSONString(message));
        if (deliverTime != 0) {
            message.setStartDeliverTime(deliverTime);
        }
        syncSend(message);
    }

    @Override
    public void sendOneWay(Message message) {
        log.info("AbstractMessageProducer.sendOneWay, oneWay send mq message:{}", JSONObject.toJSONString(message));
        producerBean.sendOneway(message);
    }

    /**
     * 发送成功，开放抽象接口供消息发送者使用
     *
     * @param message 消息体
     */
    protected abstract void onSendSuccess(Message message);

    /**
     * 发送失败，开放抽象接口供消息发送者使用
     *
     * @param message  消息体
     * @param errorMsg 错误日志
     */
    protected abstract void onSendFail(Message message, String errorMsg);
}
