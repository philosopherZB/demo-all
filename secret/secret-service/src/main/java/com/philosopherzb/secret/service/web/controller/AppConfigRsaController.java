package com.philosopherzb.secret.service.web.controller;

import com.github.pagehelper.Page;
import com.philosopherzb.secret.service.common.constant.CommonConstants;
import com.philosopherzb.secret.service.common.util.SnowflakeIdWorkerUtils;
import com.philosopherzb.secret.service.service.AppConfigRsaService;
import com.philosopherzb.secret.service.web.request.AppConfigRsaRequest;
import com.philosopherzb.secret.service.web.vo.AppConfigRsaVO;
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
@RequestMapping("/api/security/rsa")
@Validated
public class AppConfigRsaController {

    @Resource
    private AppConfigRsaService appConfigRsaService;

    @PostMapping("/create")
    public Boolean create(@Valid @RequestBody AppConfigRsaRequest request) {
        return appConfigRsaService.create(request);
    }

    @PostMapping("/update")
    public Boolean updateById(@RequestBody AppConfigRsaRequest request) {
        return appConfigRsaService.updateById(request);
    }

    @GetMapping("/changeRandomNum")
    public Boolean updateRandomNum(@NotNull(message = "id 不能为空") Long id) {
        AppConfigRsaRequest request = new AppConfigRsaRequest();
        request.setId(id);
        request.setRandomNum(SnowflakeIdWorkerUtils.generateIdWithDate());
        return appConfigRsaService.updateById(request);
    }

    @GetMapping("/deleteById")
    public Boolean closeDeleteFlag(@NotNull(message = "id 不能为空") Long id) {
        AppConfigRsaRequest request = new AppConfigRsaRequest();
        request.setId(id);
        request.setIsDelete(CommonConstants.DELETE_FLAG_1);
        return appConfigRsaService.updateById(request);
    }

    @GetMapping("/activeById")
    public Boolean activeDeleteFlag(@NotNull(message = "id 不能为空") Long id) {
        AppConfigRsaRequest request = new AppConfigRsaRequest();
        request.setId(id);
        request.setIsDelete(CommonConstants.DELETE_FLAG_0);
        return appConfigRsaService.updateById(request);
    }

    @PostMapping("/list")
    public Page<AppConfigRsaVO> query(@RequestBody AppConfigRsaRequest request) {
        return appConfigRsaService.getByPage(request);
    }
}
