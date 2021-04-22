package com.philosopherzb.springkafka.producer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.philosopherzb.springkafka.producer", "com.philosopherzb.springkafka.common"})
@MapperScan(basePackages = {"com.philosopherzb.springkafka.mapper"})
public class SpringKafkaProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaProducerApplication.class, args);
    }

}
