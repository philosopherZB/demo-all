package com.philosopherzb.commonutil.repeatscheduletasks.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * author: philosopherZB
 * date: 2020/3/10
 * 利用redis防止分布式定时任务重复执行
 */
@Aspect
@Component
public class ScheduleAspect {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleAspect.class);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

//    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void test(){
        logger.info("begin--------------");
        redisTemplate.opsForValue().set("QrMerchantKEy2020020400000004", "test001", 5, TimeUnit.MINUTES);
//        logger.info("value--------------：{}", redisTemplate.opsForValue().get("QrMerchantKEy2020020400000004"));
    }
}
