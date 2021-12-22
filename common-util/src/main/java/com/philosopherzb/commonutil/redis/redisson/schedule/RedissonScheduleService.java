package com.philosopherzb.commonutil.redis.redisson.schedule;

import com.philosopherzb.commonutil.redis.redisson.util.RedissonUtil;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * author: philosopherZB
 * date: 2020/3/6
 */
@Service
public class RedissonScheduleService {

    private static final Logger logger = LoggerFactory.getLogger(RedissonScheduleService.class);

    @Resource
    private RedissonUtil redissonUtil;

    //    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void test() {
        logger.info("ScheduleService.scheduleTask task begin");
        try {
            //单机redisson
            RLock lock = redissonUtil.redissonSingle().getLock(RedissonUtil.DEFAULT_LOCK_NAME);
            try {
                // 尝试加锁，最多等待10秒，如果等待超时将返回系统繁忙，上锁以后如果没有解锁，30秒之后将会自动解锁
                boolean isLock = lock.tryLock(10, 30, TimeUnit.SECONDS);
                if (isLock) {
                    logger.info("ScheduleService.scheduleTask ----redisson lock Success");
                } else {
                    logger.info("ScheduleService.scheduleTask ----redisson lock fail");
                }
            } catch (InterruptedException e) {
                logger.error("ScheduleService.scheduleTask ----redisson lock exception,e={}", e);
            } finally {
                // 判断当前线程是否获取到锁，是则进行解锁
                if (lock.isHeldByCurrentThread() && lock.isLocked()) {
                    lock.unlock();
                }
            }
        } catch (Exception e) {
            logger.error("ScheduleService.scheduleTask occur exception, e:{}", e);
        }
    }
}
