package com.philosopherzb.springdynamicdatasource.schedule;

import com.philosopherzb.springdynamicdatasource.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author: philosopherZB
 * date: 2020/3/4
 */
@Service
public class ScheduleService {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleService.class);
    @Resource
    private TestService testService;

    @Scheduled(fixedRate = 24*60*60*1000)
    public void test(){
        logger.info("--------------------------------------begin------------------------------");
//        testService.testCreatePerson();
//        testService.testCreateUser();
        testService.testPToU();
        logger.info("--------------------------------------end------------------------------");
    }
}
