package com.philosopherzb.rocketmq.springboot.consume.service.impl;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Service;

/**
 * author: philosopherZB
 * date: 2019/12/13
 */
@Service
@RocketMQMessageListener(topic = "${demo.rocketmq.msgExtTopic}",consumerGroup = "msg_ext_consume",selectorExpression = "tag0||tag1")
public class MsgExtConsumeServiceImpl implements RocketMQListener<String>, RocketMQPushConsumerLifecycleListener {
    @Override
    public void onMessage(String message) {
        System.out.println("---------msg_ext_consume received: " + message);
    }

    @Override
    public void prepareStart(DefaultMQPushConsumer consumer) {
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_TIMESTAMP);
        consumer.setConsumeTimestamp(String.valueOf(System.currentTimeMillis()));
    }
}
