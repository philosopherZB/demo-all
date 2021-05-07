package com.philosopherzb.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:/dubbo-consumer.xml"})
@ServletComponentScan("com.philosopherzb.gateway.filter")
public class GatewayApplication {

    public static void main(String[] args) {
        System.setProperty("dubbo.application.logger", "log4j2");
        SpringApplication.run(GatewayApplication.class, args);
    }

}
