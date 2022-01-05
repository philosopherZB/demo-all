package com.philosopherzb.commonutil.curator.schedule;

import com.philosopherzb.commonutil.curator.service.CuratorLockService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author philosopherZB
 * @date 2021/4/27
 */
@Service
public class ScheduleService {
    private static ThreadPoolExecutor pool = new ThreadPoolExecutor(8, 8, 10,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(200), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

    @Resource
    private CuratorLockService curatorLockService;

//    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void test() {
        String lockPath = "/curator/lock/test";
        pool.execute(() -> curatorLockService.lockTest(lockPath));
        pool.execute(() -> curatorLockService.lockTest(lockPath));
        pool.execute(() -> curatorLockService.lockTest(lockPath));
        pool.execute(() -> curatorLockService.lockTest(lockPath));
    }
}
