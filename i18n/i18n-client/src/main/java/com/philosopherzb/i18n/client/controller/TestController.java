package com.philosopherzb.i18n.client.controller;

import com.philosopherzb.i18n.MessageUtil;
import com.philosopherzb.i18n.client.advice.config.I18nConstant;
import com.philosopherzb.i18n.client.request.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author philosopherZB
 * @date 2022/1/6
 */

@Validated
@Slf4j
@RestController
@RequestMapping("/api")
public class TestController {

    @RequestMapping(value = "/getByName", method = RequestMethod.GET)
    public String getByName(@NotBlank(message = "key-{PARAM_INVALID}") String key) {
        try {
            log.info("i18n prepared:{}", MessageUtil.prepared());
            log.info("i18n value:{}", MessageUtil.get(key));
            log.info("i18n value:{}", MessageUtil.get("NAME_BY", "test"));
            return MessageUtil.get(key);
        } catch (Exception e) {
            log.error("getByName occur exception: ", e);
            return "failure";
        }
    }

    @RequestMapping(value = "/getByNacos", method = RequestMethod.GET)
    public String getByNacos(@NotBlank(message = I18nConstant.PARAM_IS_NULL_BY_SEPARATE + "key") String key) {
        try {
            return MessageUtil.get(key);
        } catch (Exception e) {
            log.error("getByName occur exception: ", e);
            return "failure";
        }
    }

    @PostMapping(value = "/getOrder")
    public String getOrder(@Valid @RequestBody OrderRequest request) {
        try {
            log.info("request:{}", request.toString());
            return "success";
        } catch (Exception e) {
            log.error("getOrder occur exception: ", e);
            return "failure";
        }
    }
}

