package com.philosopherzb.commonutil.async.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * author: philosopherZB
 * date: 2020/3/9
 */
@Service
public class TestService2 {
    private static final Logger logger = LoggerFactory.getLogger(TestService2.class);

    @Async("asyncServiceExecutor")
    public void printMsg(){
        logger.info("execute async method TestService2.printMsg, currentThread name:{}", Thread.currentThread().getName());
    }
}
