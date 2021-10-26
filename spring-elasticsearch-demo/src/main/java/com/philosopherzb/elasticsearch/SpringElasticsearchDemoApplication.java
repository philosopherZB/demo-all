package com.philosopherzb.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringElasticsearchDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringElasticsearchDemoApplication.class, args);
    }

}
