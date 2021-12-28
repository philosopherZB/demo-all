package com.philosopherzb.nacosfeignprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author philosopherZB
 * @date 2021/12/28
 */
@RestController
@RequestMapping("/api")
public class NacosProviderController {

    /**
     * 此接口被feign调用
     *
     * @return str
     */
    @GetMapping("/getStoreByFeign")
    public String getStore() {
        return "test content-------------->hello world";
    }
}
