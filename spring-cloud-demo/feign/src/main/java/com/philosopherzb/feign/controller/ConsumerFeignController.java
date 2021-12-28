package com.philosopherzb.feign.controller;

import com.philosopherzb.nacosfeignapi.api.NacosStoreService;
import com.philosopherzb.nacosfeignapi.request.NacosStoreRequest;
import com.philosopherzb.nacosfeignapi.vo.NacosStoreVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping("/test2")
    public NacosStoreVO test(@RequestBody NacosStoreRequest request) {
        return nacosStoreService.getStores(request);
    }
}
