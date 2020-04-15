package com.philosopherzb.shardingdb.schedule;

import com.philosopherzb.shardingdb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author: philosopherZB
 * date: 2020/4/3
 */
@Service
public class ScheduleService {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleService.class);

    @Resource
    private UserService userService;

    @Scheduled(fixedRate = 24*60*60*1000)
    public void test(){
        logger.info("--------------------------------------begin------------------------------");
        try {
            userService.insertUser();
//            userService.getUser();
        } catch (Exception e) {
            logger.error("occur exception:{}",e);
        }
        logger.info("--------------------------------------end------------------------------");
    }
}
