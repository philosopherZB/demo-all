package com.philosopherzb.nacosfeignapi.api;

import com.philosopherzb.nacosfeignapi.request.NacosStoreRequest;
import com.philosopherzb.nacosfeignapi.vo.NacosStoreVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author philosopherZB
 * @date 2021/12/24
 */
// @FeignClient 中的value为服务提供者的注册名（如果服务提供者未明确指定，则为服务提供者配置文件中的spring.application.name属性）
@FeignClient(value = "nacos-provider")
public interface NacosStoreService {

    /**
     * GetMapping 中的value是服务提供者中的接口地址
     *
     * @return str
     */
    @PostMapping(value = "/api/getStoreByFeign")
    NacosStoreVO getStores(@RequestBody NacosStoreRequest request);
}
