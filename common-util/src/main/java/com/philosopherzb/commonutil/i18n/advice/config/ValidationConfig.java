package com.philosopherzb.commonutil.i18n.advice.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * 此配置器对于 javax.validation.constraints 中的message的格式要求为el形式
 * eg:  @NotBlank(message = "{PARAM_INVALID}")
 * eg:  @NotBlank(message = "prefix-{PARAM_INVALID}-suffix")
 * 其中 PARAM_INVALID 为配置文件中的key
 *
 * @author philosopherZB
 * @date 2022/1/5
 */
@Configuration
public class ValidationConfig {

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }

}
