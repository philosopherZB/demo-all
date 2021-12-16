package com.philosopherzb.commonutil.i18n.controller;

import com.philosopherzb.commonutil.i18n.service.I18NDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author philosopherZB
 * @date 2021/12/15
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class TestController {
    @Resource
    private I18NDemoService i18NDemoService;

    @RequestMapping(value = "/getByName", method = RequestMethod.GET)
    public String getByName(String name) {
        try {
            return i18NDemoService.getByName(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "failure";
        }
    }
}
