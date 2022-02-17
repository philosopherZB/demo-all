package com.philosopherzb.i18n;

import org.springframework.context.annotation.Import;

/**
 * @author philosopherZB
 * @date 2022/2/16
 */
@Import({MessageSourceConfig.class, LocaleConfig.class, NacosConfig.class})
public class I18NAutoConfiguration {
}
