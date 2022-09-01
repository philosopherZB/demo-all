package com.philosopherzb.springkafka.producer.schedule;

import com.philosopherzb.springkafka.common.util.JacksonUtils;
import com.philosopherzb.springkafka.producer.constant.TopicEnum;
import com.philosopherzb.springkafka.producer.domain.KafkaMessage;
import com.philosopherzb.springkafka.producer.service.SendMsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author philosopherZB
 * @date 2021/4/21
 */
@Slf4j
@Component
public class ScheduleService {

    @Resource
    private SendMsgService sendMsgService;

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void sendMsgTask() {
        log.info("ScheduleService.sendMsgTask begin...");
        try {
            KafkaMessage message = new KafkaMessage();
            message.setTopic(TopicEnum.DEMO);
            Map<String, String> map = new HashMap<>();
            map.put("name", "kafka-test");
            map.put("age", "41");
            map.put("type", "test");
            message.setContent(JacksonUtils.serialize(map));
//            sendMsgService.asyncSend(message);
            boolean flag = sendMsgService.syncSendForTimeout(message, 3, TimeUnit.SECONDS);
//            boolean flag = sendMsgService.syncSend(message);
            log.info("ScheduleService.sendMsgTask result, flag:{}", flag);
        } catch (Exception e) {
            log.info("ScheduleService.sendMsgTask occur exception, e:", e);
        }
    }
}
