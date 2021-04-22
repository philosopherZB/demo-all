package com.philosopherzb.springkafka.consumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableKafka
@SpringBootApplication(scanBasePackages = {"com.philosopherzb.springkafka.consumer", "com.philosopherzb.springkafka.common"})
@MapperScan(basePackages = {"com.philosopherzb.springkafka.mapper"})
public class SpringKafkaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaConsumerApplication.class, args);
    }

}
