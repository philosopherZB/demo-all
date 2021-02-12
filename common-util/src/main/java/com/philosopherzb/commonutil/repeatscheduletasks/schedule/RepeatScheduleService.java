package com.philosopherzb.commonutil.repeatscheduletasks.schedule;

import com.philosopherzb.commonutil.redis.redisson.util.RedissonUtil;
import com.philosopherzb.commonutil.repeatscheduletasks.annotation.RepeatScheduleTask;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

/**
 * author: philosopherZB
 * date: 2020/3/23
 */
@Service
public class RepeatScheduleService {

    private static final Logger logger = LoggerFactory.getLogger(RepeatScheduleService.class);

    private static final String KEY = "common-util";
    private static final Integer TIMEOUT = 1;

    @Resource
    private RedissonUtil redissonUtil;
    @Resource
    private RedisTemplate<String, String> redisTemplate;

//    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void test(){
        logger.info("ScheduleService.scheduleTask task begin");
        try {
            //单机redisson
            RLock lock = redissonUtil.redissonSingle().getLock(RedissonUtil.DEFAULT_LOCK_NAME);
            try {
                // 尝试加锁，最多等待10秒，如果等待超时将返回系统繁忙，上锁以后如果没有解锁，30秒之后将会自动解锁
                boolean isLock = lock.tryLock(10, 30, TimeUnit.SECONDS);
                if (isLock) {
                    logger.info("ScheduleService.scheduleTask ----redisson lock Success");
                    String ip = InetAddress.getLocalHost().getHostAddress();
                    String currentIp = redisTemplate.opsForValue().get(KEY);
                    if (currentIp == null){
                        redisTemplate.opsForValue().set(KEY, ip, TIMEOUT, TimeUnit.DAYS);
                        logger.info("ScheduleService.scheduleTask ----execute task, host ip:{}", ip);
                        return;
                    }
                    if (currentIp.equals(ip)){
                        logger.info("ScheduleService.scheduleTask ----execute task, current ip:{}", ip);
                    } else {
                        logger.info("ScheduleService.scheduleTask ----other task executing , current ip:{}", currentIp);
                    }
                } else {
                    logger.info("ScheduleService.scheduleTask ----redisson lock fail");
                }
            } catch (InterruptedException e) {
                logger.error("ScheduleService.scheduleTask ----redisson lock exception,e={}",e);
            } finally {
                // 判断当前线程是否获取到锁，是则进行解锁
                if(lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        } catch (Exception e) {
            logger.error("ScheduleService.scheduleTask occur exception, e:{}",e);
        }
    }

    @RepeatScheduleTask(waitTime = 10, leaseTime = 30, timeUnit = TimeUnit.SECONDS)
//    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void insertSecret(){
        logger.info("ScheduleService.insertSecret begin");
    }
}
