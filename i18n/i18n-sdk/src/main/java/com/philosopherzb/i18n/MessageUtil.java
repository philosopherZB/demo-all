package com.philosopherzb.i18n;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @author philosopherZB
 * @date 2022/2/16
 */
@Slf4j
@DependsOn("messageSource")
public class MessageUtil {
    private static MessageSource messageSource;

    static void setMessageSource(MessageSource source) {
        messageSource = source;
    }

    public static boolean prepared() {
        return messageSource != null;
    }

    public static String get(String key) {
        try {
            return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException | NullPointerException e) {
            log.debug("Get configuration exception! Abnormal information: ", e);
        }
        return key;
    }

    public static String get(String key, Object... params) {
        try {
            return messageSource.getMessage(key, params, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException | NullPointerException e) {
            log.debug("Get configuration exception! Abnormal information: ", e);
        }
        return key;
    }
}
