package com.philosopherzb.i18n;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author philosopherZB
 * @date 2022/2/16
 */
@Slf4j
@EnableConfigurationProperties(MessageProperties.class)
public class MessageSourceConfig {
    @Resource
    private MessageProperties messageProperties;

    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding(messageProperties.getEncoding());
        messageSource.setCacheMillis(messageProperties.getCacheMillis());
        messageSource.setUseCodeAsDefaultMessage(true);

        if (I18NMessageMode.LOCAL.equals(messageProperties.getMode())) {
            String name = messageProperties.getBasename();
            if (StringUtils.isBlank(name)) {
                name = "i18n/messages";
            }
            name = StringUtils.replace(name, ".", "/");
            if (!name.contains("i18n/commons")) {
                name = name + ",i18n/commons";
            }

            messageSource.setBasenames(StringUtils.split(name, ","));
            MessageUtil.setMessageSource(messageSource);
            return messageSource;
        }
        if (I18NMessageMode.NACOS.equals(messageProperties.getMode())) {
            String path = ResourceUtils.FILE_URL_PREFIX + System.getProperty("user.dir") + File.separator + messageProperties.getBaseFolder() + File.separator + messageProperties.getBasename();
            messageSource.setBasename(path);
            MessageUtil.setMessageSource(messageSource);
            return messageSource;
        }
        log.error("i18n message properties config--> invalid mode:{}", messageProperties.getMode());
        throw new IllegalArgumentException("i18n message mode missing");
    }
}
