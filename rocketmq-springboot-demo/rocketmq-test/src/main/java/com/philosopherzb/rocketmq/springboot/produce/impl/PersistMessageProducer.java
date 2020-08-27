package com.philosopherzb.rocketmq.springboot.produce.impl;

import com.aliyun.openservices.ons.api.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 消息持久化
 * author: philosopherZB
 * date: 2020/8/26
 */
@Slf4j
@Component("messageProducer")
public class PersistMessageProducer extends AbstractMessageProducer {

    @Override
    protected void onSendSuccess(Message message) {
        // 消息入库
    }

    @Override
    protected void onSendFail(Message message, String errorMsg) {
        // 消息入库
    }
}
