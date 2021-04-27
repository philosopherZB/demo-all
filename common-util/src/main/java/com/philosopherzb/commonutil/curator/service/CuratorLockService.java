package com.philosopherzb.commonutil.curator.service;

import com.philosopherzb.commonutil.curator.config.CuratorConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author philosopherZB
 * @date 2021/4/27
 */
@Slf4j
@Service
public class CuratorLockService {
    @Resource
    private CuratorConfig curatorConfig;

    public void lockTest(String lockPath) {
        // 共享可重入锁
        InterProcessMutex lock = new InterProcessMutex(curatorConfig.curatorFramework(), lockPath);
        try {
            if (lock.acquire(0, TimeUnit.SECONDS)) {
                log.info("get lock success");
                Thread.sleep(30 * 1000);
            } else {
                log.info("get lock failure");
            }
        } catch (Exception e) {
            log.error("get lock occur exception, e:", e);
        } finally {
            try {
                if (lock.isOwnedByCurrentThread()) {
                    lock.release();
                }
            } catch (Exception e) {
                log.error("release lock occur exception, e:", e);
            }
        }
    }
}
