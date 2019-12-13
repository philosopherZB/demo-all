package com.philosopherzb.rocketmq.springboot.consume.service;

import org.apache.rocketmq.spring.core.RocketMQListener;

/**
 * author: philosopherZB
 * date: 2019/12/12
 */
public interface UserConsumeService extends RocketMQListener<String> {
}
