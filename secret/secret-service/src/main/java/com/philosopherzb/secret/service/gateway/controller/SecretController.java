package com.philosopherzb.secret.service.gateway.controller;

import cn.hutool.json.JSONUtil;
import com.philosopherzb.secret.service.gateway.request.ApiRequest;
import com.philosopherzb.secret.service.gateway.request.SecurityRequest;
import com.philosopherzb.secret.service.gateway.vo.SecurityVO;
import com.philosopherzb.secret.service.service.SecretService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author philosopherZB
 * @date 2022/2/8
 */
@Slf4j
@RestController
@RequestMapping("/api/security")
public class SecretController {

    @Resource
    private SecretService secretService;

    @PostMapping("/getSecretKey")
    public SecurityVO getSecretKey(@RequestBody ApiRequest request) {
        log.info("SecretController.getSecretKey request: {}", request.toString());
        SecurityRequest securityRequest = JSONUtil.toBean(request.getBizContent(), SecurityRequest.class);
        return secretService.getSecurity(request.getAppId(), securityRequest);
    }
}
