package com.philosopherzb.commonutil.i18n.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Locale;

/**
 * @author philosopherZB
 * @date 2021/12/15
 */
@Slf4j
@Component
public class PropertiesTools {
    @Resource
    private MessageSource messageSource;

    private static PropertiesTools propertiesTools;

    // 初始化的时候，将本类中的 propertiesTools 赋值给静态的本类变量
    @PostConstruct
    public void init() {
        propertiesTools = this;
    }

    public static String getProperties(String name) {
        if (StringUtils.isBlank(name)) {
            return "name not exist";
        }
        try {
            Locale locale = LocaleContextHolder.getLocale();
            return propertiesTools.messageSource.getMessage(name, null, locale);
        } catch (NoSuchMessageException e) {
            log.error("Get configuration exception!Abnormal information:{}", e);
        }
        return name;
    }

    public static String getProperties(String name, Object... params) {
        if (StringUtils.isBlank(name)) {
            return "name not exist";
        }
        try {
            Locale locale = LocaleContextHolder.getLocale();
            return propertiesTools.messageSource.getMessage(name, params, locale);
        } catch (NoSuchMessageException e) {
            log.error("Get configuration exception!Abnormal information:{}", e);
        }
        return name;
    }
}
