package com.philosopherzb.rocketmq.springboot.consume.service.impl;

import com.philosopherzb.rocketmq.springboot.consume.service.UserConsumeService;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.springframework.stereotype.Service;

/**
 * author: philosopherZB
 * date: 2019/12/12
 */
@Service
@RocketMQMessageListener(nameServer = "${demo.rocketmq.extNameServer}",topic = "${demo.rocketmq.userTopic}",consumerGroup = "user_consume")
public class UserConsumeServiceImpl implements UserConsumeService {
    @Override
    public void onMessage(String message) {
        System.out.println("---------user_consumer received: " + message);
    }
}
