package com.philosopherzb.springaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringAopTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAopTestApplication.class, args);
    }

}
