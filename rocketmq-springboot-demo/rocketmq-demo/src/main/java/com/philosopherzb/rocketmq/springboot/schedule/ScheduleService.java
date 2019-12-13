package com.philosopherzb.rocketmq.springboot.schedule;

import com.philosopherzb.rocketmq.springboot.produce.service.ProduceService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author: philosopherZB
 * date: 2019/12/12
 */
@Service
public class ScheduleService {

    @Resource
    private ProduceService produceService;

    @Scheduled(fixedRate = 24*60*60*1000)
    public void test(){
        //普通消息
        produceService.testMessage();
        //批量消息
//        produceService.testBatchMessages();
        //事务消息
//        try {
//            produceService.testTransaction();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
