package com.philosopherzb.rocketmq.springboot.produce.service;

import org.apache.rocketmq.spring.annotation.ExtRocketMQTemplateConfiguration;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

/**
 * author: philosopherZB
 * date: 2019/12/12
 */
@ExtRocketMQTemplateConfiguration(nameServer = "${demo.rocketmq.extNameServer}")
public class ExtRocketMQTemplate extends RocketMQTemplate {
}
