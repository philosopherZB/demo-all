package com.philosopherzb.commonutil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CommonUtilApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonUtilApplication.class, args);
    }

}
