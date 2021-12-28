package com.philosopherzb.nacosfeignprovider.controller;

import com.philosopherzb.nacosfeignapi.request.NacosStoreRequest;
import com.philosopherzb.nacosfeignapi.vo.NacosStoreVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @PostMapping("/getStoreByFeign")
    public NacosStoreVO getStore(@RequestBody NacosStoreRequest request) {
        NacosStoreVO vo = new NacosStoreVO();
        BeanUtils.copyProperties(request, vo);
        vo.setAge(20);
        return vo;
    }
}
