package com.philosopherzb.i18n;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

/**
 * @author philosopherZB
 * @date 2022/2/16
 */
public class LocaleConfig {
    /**
     * 默认解析器 其中locale表示默认语言
     */
    @Bean
    public LocaleResolver localeResolver() {
        I18NAcceptHeaderLocaleResolver localeResolver = new I18NAcceptHeaderLocaleResolver();
        localeResolver.setSupportedLocales(LocaleParamManager.LOCALES);
        localeResolver.setDefaultLocale(Locale.CHINA);
        return localeResolver;
    }
}
