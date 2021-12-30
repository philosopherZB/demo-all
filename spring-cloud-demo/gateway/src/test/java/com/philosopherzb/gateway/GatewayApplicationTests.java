package com.philosopherzb.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class GatewayApplicationTests {

    @Test
    void contextLoads() {
        String s = new RestTemplate().getForObject("http://127.0.0.1:8567/api/getHello?name=world00001", String.class);
        System.out.println(s);
    }

}
