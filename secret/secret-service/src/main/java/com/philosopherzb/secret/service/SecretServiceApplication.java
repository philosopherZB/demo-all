package com.philosopherzb.secret.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.philosopherzb.secret.service.dal.mapper"})
@ServletComponentScan("com.philosopherzb.secret.service.gateway.filter")
public class SecretServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecretServiceApplication.class, args);
    }

}
