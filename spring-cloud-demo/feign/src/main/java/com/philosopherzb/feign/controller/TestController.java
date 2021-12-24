package com.philosopherzb.feign.controller;

import com.philosopherzb.feign.service.StoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * see: https://cloud.spring.io/spring-cloud-openfeign/reference/html/
 *
 * @author philosopherZB
 * @date 2021/12/24
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @Resource
    private StoreService storeService;

    /**
     * 此接口被feign调用
     *
     * @return str
     */
    @GetMapping("/getStore")
    public String getStore() {
        return "test content";
    }

    /**
     * postman 测试接口
     *
     * @return str
     */
    @GetMapping("/test")
    public String test() {
        return storeService.getStores();
    }
}
