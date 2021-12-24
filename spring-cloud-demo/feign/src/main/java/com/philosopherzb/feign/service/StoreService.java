package com.philosopherzb.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author philosopherZB
 * @date 2021/12/24
 */
@FeignClient(value = "store", url = "http://127.0.0.1:8989")
public interface StoreService {

    @GetMapping(value = "/api/getStore")
    String getStores();
}
