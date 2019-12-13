package com.philosopherzb.rocketmq.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RocketmqDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketmqDemoApplication.class, args);
    }

}
