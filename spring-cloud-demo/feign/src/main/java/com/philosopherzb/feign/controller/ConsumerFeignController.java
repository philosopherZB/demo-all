package com.philosopherzb.feign.controller;

import com.philosopherzb.nacosfeignapi.api.NacosStoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author philosopherZB
 * @date 2021/12/28
 */
@RestController
@RequestMapping("/api")
public class ConsumerFeignController {

    @Resource
    private NacosStoreService nacosStoreService;

    /**
     * postman 测试接口
     *
     * @return str
     */
    @GetMapping("/test2")
    public String test() {
        return nacosStoreService.getStores();
    }
}
