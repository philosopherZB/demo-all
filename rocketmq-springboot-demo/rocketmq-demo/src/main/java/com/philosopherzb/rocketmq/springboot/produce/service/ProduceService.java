package com.philosopherzb.rocketmq.springboot.produce.service;

/**
 * author: philosopherZB
 * date: 2019/12/12
 */
public interface ProduceService {

    void testMessage();

    void testBatchMessages();

    void testTransaction() throws Exception;
}
