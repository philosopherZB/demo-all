package com.philosopherzb.springdynamicdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.philosopherzb.springdynamicdatasource.mapper*")
public class SpringDynamicDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDynamicDatasourceApplication.class, args);
    }

}
