package com.philosopherzb.commonutil.i18n.controller;

import com.philosopherzb.commonutil.i18n.bo.OrderRequest;
import com.philosopherzb.commonutil.i18n.service.I18NDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author philosopherZB
 * @date 2021/12/15
 */
@Validated
@Slf4j
@RestController
@RequestMapping("/api")
public class TestController {
    @Resource
    private I18NDemoService i18NDemoService;

    @RequestMapping(value = "/getByName", method = RequestMethod.GET)
    public String getByName(@NotBlank(message = "{PARAM_INVALID}") String name) {
        try {
            return i18NDemoService.getByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }

    @PostMapping(value = "/getOrder")
    public String getOrder(@Valid @RequestBody OrderRequest request) {
        try {
            log.info("request:{}", request.toString());
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }
}
