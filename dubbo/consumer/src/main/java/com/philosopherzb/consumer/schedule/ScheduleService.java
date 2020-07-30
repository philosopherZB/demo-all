package com.philosopherzb.consumer.schedule;

import com.philosopherzb.provider.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author: philosopherZB
 * date: 2020/7/29
 */
@Slf4j
@Service
public class ScheduleService {

    @Resource
    private ProviderService providerService;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void test() {
        log.info("--------------------------------------begin------------------------------");
        try {
            providerService.test();
        } catch (Exception e) {
            log.error("ScheduleService.test occur exception : ", e);
        }
        log.info("--------------------------------------end------------------------------");
    }
}
