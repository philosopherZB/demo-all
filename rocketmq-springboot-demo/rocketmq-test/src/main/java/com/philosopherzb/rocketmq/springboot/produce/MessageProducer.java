package com.philosopherzb.rocketmq.springboot.produce;

import com.aliyun.openservices.ons.api.Message;

import java.util.List;

/**
 * author: philosopherZB
 * date: 2020/8/25
 */
public interface MessageProducer {

    /**
     * 同步消息
     *
     * @param message 消息体
     */
    void syncSend(Message message);

    /**
     * 同步批量发送消息，实际上就是轮询一条条发送
     *
     * @param messageList 消息列表
     */
    void syncSendBatch(List<Message> messageList);

    /**
     * 异步消息
     *
     * @param message 消息体
     */
    void asyncSend(Message message);

    /**
     * 延时同步消息
     *
     * @param message     消息体
     * @param deliverTime 延时时间
     */
    void syncDelaySend(Message message, long deliverTime);

    /**
     * 单向消息
     *
     * @param message 消息体
     */
    void sendOneWay(Message message);
}
