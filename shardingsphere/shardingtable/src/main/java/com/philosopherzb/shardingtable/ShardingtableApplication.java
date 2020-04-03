package com.philosopherzb.shardingtable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan(basePackages = {"com.philosopherzb.shardingtable.mapper"})
@EnableScheduling
public class ShardingtableApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingtableApplication.class, args);
    }

}
