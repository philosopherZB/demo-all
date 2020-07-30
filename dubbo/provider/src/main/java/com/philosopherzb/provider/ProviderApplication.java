package com.philosopherzb.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = {"classpath:/dubbo-provider.xml"})
public class ProviderApplication {

    public static void main(String[] args) {
        System.setProperty("dubbo.application.logger", "log4j2");
        SpringApplication.run(ProviderApplication.class, args);
    }

}
