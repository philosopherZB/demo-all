package com.philosopherzb.rocketmq.springboot.consume.service.impl;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * author: philosopherZB
 * date: 2019/12/13
 */
@Service
@RocketMQMessageListener(nameServer = "${demo.rocketmq.extNameServer}",topic = "${demo.rocketmq.orderTopic}",consumerGroup = "order_consumer")
public class OrderConsumeServiceImpl implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.println("---------order_consumer received: " + message);
    }
}
