package com.philosopherzb.nacosfeignprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.philosopherzb")
@EnableDiscoveryClient
public class NacosFeignProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosFeignProviderApplication.class, args);
    }

}
