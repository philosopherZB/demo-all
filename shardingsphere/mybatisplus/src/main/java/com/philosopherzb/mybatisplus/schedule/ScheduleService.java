package com.philosopherzb.mybatisplus.schedule;

import com.philosopherzb.mybatisplus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author: philosopherZB
 * date: 2020/4/3
 */
@Slf4j
@Service
public class ScheduleService {

    @Resource
    private UserService userService;

    @Scheduled(fixedRate = 24 * 60 * 60 * 1000)
    public void test() {
        try {
            log.info("count:{}", userService.testCount(1L));
        } catch (Exception e) {
            log.error("occur exception:{}", e);
        }
    }
}
