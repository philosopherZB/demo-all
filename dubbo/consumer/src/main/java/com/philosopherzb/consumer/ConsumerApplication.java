package com.philosopherzb.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ImportResource(value = {"classpath:/dubbo-consumer.xml"})
@EnableScheduling
public class ConsumerApplication {

    public static void main(String[] args) {
        System.setProperty("dubbo.application.logger", "log4j2");
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
