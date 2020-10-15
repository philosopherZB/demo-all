package com.philosopherzb.nettydemo.util;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义线程池
 * author: philosopherZB
 * date: 2020/8/11
 */
@Slf4j
public class NettyThreadFactory implements ThreadFactory {

    /**
     * 线程前缀名
     */
    private final String PREFIX;

    /**
     * 线程编码
     */
    private final AtomicInteger nextId = new AtomicInteger(1);

    /**
     * 定义线程池名称，用于日志排查
     *
     * @param whatFeatureOfPoolDesc 线程池用途
     */
    public NettyThreadFactory(String whatFeatureOfPoolDesc) {
        PREFIX = "From NettyThreadFactory's " + whatFeatureOfPoolDesc + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = PREFIX + nextId.getAndIncrement();
        Thread thread = new Thread(null, r, name, 0);
        log.info("thread pool new thread: {}", name);
        return thread;
    }
}
