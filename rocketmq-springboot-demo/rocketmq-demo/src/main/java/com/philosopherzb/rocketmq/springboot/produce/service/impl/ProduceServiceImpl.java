package com.philosopherzb.rocketmq.springboot.produce.service.impl;

import com.philosopherzb.rocketmq.springboot.dto.OrderDto;
import com.philosopherzb.rocketmq.springboot.dto.RocketPropertyDto;
import com.philosopherzb.rocketmq.springboot.dto.UserDto;
import com.philosopherzb.rocketmq.springboot.produce.service.ExtRocketMQTemplate;
import com.philosopherzb.rocketmq.springboot.produce.service.ProduceService;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * author: philosopherZB
 * date: 2019/12/12
 */
@Service
public class ProduceServiceImpl implements ProduceService {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Resource
    private ExtRocketMQTemplate extRocketMQTemplate;

    @Resource
    private RocketPropertyDto rocketPropertyDto;

    @Override
    public void testMessage() {
//        //send string
//        SendResult sendResult = rocketMQTemplate.syncSend(rocketPropertyDto.getTopic(),"Test Send String Message");
//        System.out.printf("rocketMQTemplate syncSend String to topic %s sendResult=%s %n", rocketPropertyDto.getTopic(), sendResult);
//
        //send object
        SendResult sendResult = rocketMQTemplate.syncSend(rocketPropertyDto.getUserTopic(),new UserDto("001","TestName001"));
        System.out.printf("rocketMQTemplate syncSend object to topic %s sendResult=%s %n", rocketPropertyDto.getUserTopic(), sendResult);

        //use messageBuilder
        sendResult = rocketMQTemplate.syncSend(rocketPropertyDto.getUserTopic(), MessageBuilder.withPayload(
                new UserDto("002","TestName002")).setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE).build());
        System.out.printf("rocketMQTemplate syncSend use messageBuilder to topic %s sendResult=%s %n", rocketPropertyDto.getUserTopic(), sendResult);
//
//        //send string by MessageBuilder
//        sendResult = rocketMQTemplate.syncSend(rocketPropertyDto.getTopic(),MessageBuilder.withPayload("Test Send String Message By MessageBuilder").build());
//        System.out.printf("rocketMQTemplate syncSend String to topic %s sendResult=%s %n", rocketPropertyDto.getTopic(), sendResult);
//
//        //use the extRocketMQTemplate send string
//        sendResult = extRocketMQTemplate.syncSend(rocketPropertyDto.getTopic(),MessageBuilder.withPayload("Test extRocketMQTemplate Send String Message".getBytes()).build());
//        System.out.printf("extRocketMQTemplate syncSend String to topic %s sendResult=%s %n", rocketPropertyDto.getTopic(), sendResult);
//
//        //async send message
//        rocketMQTemplate.asyncSend(rocketPropertyDto.getOrderTopic(), new OrderDto("orderId_001", new BigDecimal("66.66")), new SendCallback() {
//            @Override
//            public void onSuccess(SendResult sendResult) {
//                System.out.printf("rocketMQTemplate async onSuccess SendResult=%s %n", sendResult);
//            }
//
//            @Override
//            public void onException(Throwable e) {
//                System.out.printf("rocketMQTemplate async onException Throwable=%s %n", e);
//            }
//        });

//        // Send message with special tag
//        rocketMQTemplate.convertAndSend(rocketPropertyDto.getMsgExtTopic() + ":tag0", "I'm from tag0"); //tag0 will not be consumer-selected
//        System.out.printf("convertAndSend syncSend topic %s tag %s %n", rocketPropertyDto.getMsgExtTopic(), "tag0");
//        rocketMQTemplate.convertAndSend(rocketPropertyDto.getMsgExtTopic() + ":tag1", "I'm from tag1");
//        System.out.printf("convertAndSend syncSend topic %s tag %s %n", rocketPropertyDto.getMsgExtTopic(), "tag1");

    }

    @Override
    public void testBatchMessages() {
        List<Message> messages = new ArrayList<>();
        for(int i=0; i<5; i++){
            messages.add(MessageBuilder.withPayload("send batch message#" + i).
                    setHeader(RocketMQHeaders.KEYS,"KEY_" + i).build());
        }
        SendResult sendResult = rocketMQTemplate.syncSend(rocketPropertyDto.getTopic(),messages,60000);
        System.out.println("testBatchMessages batch messages send result :" + sendResult);
    }

    @Override
    public void testTransaction() throws Exception{
        String[] tags = new String[]{"tag1","tag2","tag3","tag4","tag5"};
        for(int i=0; i<10; i++){
            Message msg = MessageBuilder.withPayload("testTransaction message" + i).
                    setHeader(RocketMQHeaders.TRANSACTION_ID,"KEY_" + i).build();
            SendResult sendResult = rocketMQTemplate.sendMessageInTransaction(
                    rocketPropertyDto.getTransTopic(),rocketPropertyDto.getTransTopic() + ":" + tags[i % tags.length],msg,null);
            System.out.printf("testTransaction send Transactional msg body = %s , sendResult=%s %n",
                    msg.getPayload(), sendResult.getSendStatus());
            Thread.sleep(10);
        }
    }
}
