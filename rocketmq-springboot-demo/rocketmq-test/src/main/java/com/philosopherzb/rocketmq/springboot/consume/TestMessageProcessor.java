package com.philosopherzb.rocketmq.springboot.consume;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.Message;
import com.philosopherzb.rocketmq.springboot.config.MqConfig;
import com.philosopherzb.rocketmq.springboot.constant.MqConstant;
import com.philosopherzb.rocketmq.springboot.domain.MqAbnormalMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

/**
 * author: philosopherZB
 * date: 2020/9/4
 */
@Slf4j
@Component("testMessageListener")
public class TestMessageProcessor extends AbstractProcessor {

    @Resource
    private MqConfig mqConfig;

    @Override
    protected void consumeFailure(Message message) {
        CompletableFuture.supplyAsync(() -> {
            MqAbnormalMessage unconsumedMessage = new MqAbnormalMessage();
            unconsumedMessage.setId(1L);
            unconsumedMessage.setTopic(message.getTopic());
            unconsumedMessage.setGroup("groupId");
            unconsumedMessage.setTag(message.getTag());
            unconsumedMessage.setKey(message.getKey());
            unconsumedMessage.setType("msg_type");
            unconsumedMessage.setUserProperties(message.getUserProperties(message.getKey()));
            unconsumedMessage.setMessageId(message.getMsgID());
            unconsumedMessage.setRetryTime(getThreshold());
            unconsumedMessage.setBody(new String(message.getBody(), StandardCharsets.UTF_8));
            unconsumedMessage.setErrorMsg("handle msg_type fail, consume msg_type message fail");
            // 发送失败入库
//            return unconsumedMessageMapper.save(unconsumedMessage);
            return 1;
        }).whenComplete((t, v) -> {
            if (t < 1) {
                log.info("test message insert db error");
            } else if (v != null) {
                log.info("test message insert db error:{}", v);
            }
        });
    }

    @Override
    protected Action handleMessage(Message message) {
        try {
            String tag = message.getTag();
            byte[] body = message.getBody();
            String topic = message.getTopic();
            // 符合条件才会进行操作
            if (mqConfig.getTopic().equals(topic) && MqConstant.TEST.equals(tag)) {
                String messageString = new String(body, StandardCharsets.UTF_8);
                log.info("==>received msg, start handle msg_type, message={}", messageString);
                // 序列化消息，并处理对应业务逻辑
                if (true) {
                    log.info("==>handle msg_type success...test={}");
                    return Action.CommitMessage;
                } else {
                    log.warn("==>handle msg_type fail...test={}");
                    return Action.ReconsumeLater;
                }
            }
            // 为了防止消息的丢失
            return Action.ReconsumeLater;
        } catch (Exception e) {
            log.error("consume message error,error={},=====message={}", e, new String(message.getBody(), StandardCharsets.UTF_8));
            // 消费失败
            return Action.ReconsumeLater;
        }
    }

    @Override
    protected int getThreshold() {
        // 可配置化
        int time = Integer.parseInt("3");
        return time == 0 ? 3 : time;
    }
}
