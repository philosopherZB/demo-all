package com.philosopherzb.rocketmq.springboot.test.mq;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Message;
import com.philosopherzb.rocketmq.springboot.config.MqConfig;
import com.philosopherzb.rocketmq.springboot.constant.MessageEnum;
import com.philosopherzb.rocketmq.springboot.message.TestMessage;
import com.philosopherzb.rocketmq.springboot.produce.MessageProducer;
import com.philosopherzb.rocketmq.springboot.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * author: philosopherZB
 * date: 2020/11/19
 */
@Slf4j
@Service
public class TestService {
    @Resource
    @Qualifier("defaultMessageProducer")
    private MessageProducer messageProducer;
    @Resource
    private MqConfig mqConfig;

    private void sendMsg(TestMessage testMessage) {
        // 发送mq
        try {
            // 序列化
            log.info("TestService.sendMsg, testMessage:{}", JSONObject.toJSONString(testMessage));

            Message cardInfoMsg = new Message(mqConfig.getTopic(), MessageEnum.TEST.getCode(), UUIDUtil.getUUID(), JSONObject.toJSONString(testMessage).getBytes(StandardCharsets.UTF_8));
            messageProducer.asyncSend(cardInfoMsg);
        } catch (Exception e) {
            log.error("LocalCardService.sendMsg, occur exception, testMessage:{}, e:{}", JSONObject.toJSONString(testMessage), e);
        }
    }
}
