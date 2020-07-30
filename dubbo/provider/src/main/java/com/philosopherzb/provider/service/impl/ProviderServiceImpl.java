package com.philosopherzb.provider.service.impl;

import com.philosopherzb.provider.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * author: philosopherZB
 * date: 2020/7/29
 */
@Slf4j
@Service("providerService")
public class ProviderServiceImpl implements ProviderService {
    @Override
    public void test() {
        log.info("dubbo provider-----------------------");
    }
}
