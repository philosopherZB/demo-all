//package com.philosopherzb.springkafka.producer.runner;
//
//import com.philosopherzb.springkafka.common.util.UUIDUtils;
//import com.philosopherzb.springkafka.domain.KafkaAbnormalMessage;
//import com.philosopherzb.springkafka.mapper.KafkaAbnormalMessageMapper;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * @author philosopherZB
// * @date 2021/4/20
// */
//@Component
//public class TestRunner implements CommandLineRunner {
//
//    @Resource
//    private KafkaAbnormalMessageMapper kafkaAbnormalMessageMapper;
//
//    @Override
//    public void run(String... args) throws Exception {
//        KafkaAbnormalMessage message = new KafkaAbnormalMessage();
//        message.setTopic("topic");
//        message.setMsgPartition(3);
//        message.setListenerId("listenerId");
//        message.setGroupId("groupId");
//        message.setMsgKey(UUIDUtils.getUUID());
//        message.setContent("Test");
//        message.setMsgType("msgType");
//        message.setRetryCount(2);
//        message.setErrorMsg("errorMsg");
//        kafkaAbnormalMessageMapper.insert(message);
//    }
//}
