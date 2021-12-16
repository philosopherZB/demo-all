package com.philosopherzb.commonutil.i18n.config;

import com.philosopherzb.commonutil.i18n.resolver.DefaultLocaleResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author philosopherZB
 * @date 2021/12/15
 */
@Slf4j
@Configuration
public class SpringConfig {
    /**
     * apply name
     */
    @Value("${spring.application.name}")
    private String applicationName;

    @Resource
    private MessageConfig messageConfig;

    @Bean
    public LocaleResolver localeResolver() {
        return new DefaultLocaleResolver();
    }

    @Primary
    @Bean(name = "messageSource")
    @DependsOn(value = "messageConfig")
    public ReloadableResourceBundleMessageSource messageSource() {
        String path = ResourceUtils.FILE_URL_PREFIX + System.getProperty("user.dir") + File.separator + messageConfig.getBaseFolder() + File.separator + messageConfig.getBasename();
        log.info("International configuration content:{}", messageConfig);
        log.info("International configuration path:{}", path);
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(path);
        messageSource.setDefaultEncoding(messageConfig.getEncoding());
        messageSource.setCacheMillis(messageConfig.getCacheMillis());
        return messageSource;
    }
}
