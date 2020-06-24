//package com.philosopherzb.commonutil.repeatscheduletasks.aop;
//
//import com.philosopherzb.commonutil.redis.redisson.util.RedissonUtil;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.redisson.api.RLock;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.net.InetAddress;
//import java.util.concurrent.TimeUnit;
//
///**
// * author: philosopherZB
// * date: 2020/4/27
// */
//@Component
//@Aspect
//public class RepeatScheduleTaskAspect {
//
//    private static final Logger logger = LoggerFactory.getLogger(RepeatScheduleTaskAspect.class);
//
//    /**
//     * 防止定时任务重复执行配置的redis key
//     */
//    private static final String PROJECT_REDIS_KEY = "common-util";
//    /**
//     * 防止定时任务重复执行缓存时长，小时
//     */
//    private static final Long PROJECT_REDIS_TIMEOUT = 1L;
//
//    @Resource
//    private RedissonUtil redissonUtil;
//    @Resource
//    private RedisTemplate<String, String> redisTemplate;
//
//
//    @Pointcut("@within(com.philosopherzb.commonutil.repeatscheduletasks.annotation.RepeatScheduleTask) || " +
//            "@annotation(com.philosopherzb.commonutil.repeatscheduletasks.annotation.RepeatScheduleTask)")
//    public void pointCut() {
//
//    }
//
//    @Around("pointCut()")
//    public Object around(ProceedingJoinPoint pjp) {
//        logger.info("RepeatScheduleTaskAspect.around begin execute");
//        try {
//            //单机redisson
//            RLock lock = redissonUtil.redissonSingle().getLock(RedissonUtil.DEFAULT_LOCK_NAME);
//            try {
//                // 尝试加锁，最多等待10秒，如果等待超时将返回系统繁忙，上锁以后如果没有解锁，30秒之后将会自动解锁
//                boolean isLock = lock.tryLock(10, 30, TimeUnit.SECONDS);
//                if (isLock) {
//                    logger.info("ScheduleService.task ----redisson lock Success");
//                    String localIp = InetAddress.getLocalHost().getHostAddress();
//                    String executeIp = redisTemplate.opsForValue().get(PROJECT_REDIS_KEY);
//                    if (executeIp == null) {
//                        redisTemplate.opsForValue().set(PROJECT_REDIS_KEY, localIp, PROJECT_REDIS_TIMEOUT, TimeUnit.HOURS);
//                        logger.info("ScheduleService.scheduleTask ----execute task, host localIp:{}", localIp);
//                        return pjp.proceed();
//                    }
//                    if (executeIp.equals(localIp)) {
//                        logger.info("ScheduleService.scheduleTask ----execute task, host executeIp:{}", executeIp);
//                        return pjp.proceed();
//                    } else {
//                        logger.info("ScheduleService.task ----other task executing , current ip:{}, execute task ip:{}", localIp, executeIp);
//                    }
//                } else {
//                    logger.info("ScheduleService.task ----redisson lock fail");
//                }
//            } catch (InterruptedException e) {
//                logger.error("ScheduleService.task ----redisson lock exception,e={}", e);
//            } finally {
//                // 判断当前线程是否获取到锁，是则进行解锁
//                if (lock.isHeldByCurrentThread()) {
//                    lock.unlock();
//                }
//            }
//        } catch (Throwable throwable) {
//            logger.error("ScheduleService.task occur exception, e:{}", throwable);
//        }
//        return null;
//    }
//}
