package com.philosopherzb.commonutil.i18n.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

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

    public String getProperties(String name) {
        try {
            Locale locale = LocaleContextHolder.getLocale();
            return messageSource.getMessage(name, null, locale);
        } catch (NoSuchMessageException e) {
            log.error("Get configuration exception!Abnormal information:{}", e);
        }
        return null;
    }
}
