package com.philosopherzb.secret.service.web.controller;

import com.github.pagehelper.Page;
import com.philosopherzb.secret.service.service.AppConfigAesService;
import com.philosopherzb.secret.service.web.request.AppConfigAesRequest;
import com.philosopherzb.secret.service.web.vo.AppConfigAesVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author philosopherZB
 * @date 2022/1/21
 */
@Slf4j
@RestController
@RequestMapping("/api/security/aes")
@Validated
public class AppConfigAesController {

    @Resource
    private AppConfigAesService appConfigAesService;

    @GetMapping("/create")
    public Boolean create(@NotNull(message = "appId 不能为空") String appId) {
        return appConfigAesService.create(appId);
    }

    @GetMapping("/upgradeAes")
    public Boolean upgradeAes(@NotNull(message = "appId 不能为空") String appId) {
        return appConfigAesService.upgradeAes(appId);
    }

    @PostMapping("/list")
    public Page<AppConfigAesVO> query(@Valid @RequestBody AppConfigAesRequest request) {
        return appConfigAesService.getByPage(request);
    }
}
