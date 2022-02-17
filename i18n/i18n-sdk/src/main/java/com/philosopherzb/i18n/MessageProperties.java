package com.philosopherzb.i18n;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.charset.StandardCharsets;

/**
 * @author philosopherZB
 * @date 2022/1/6
 */
@Data
@ConfigurationProperties(prefix = "spring.messages")
public class MessageProperties {

    /**
     * i18n 存储格式形式：LOCAL-本地，NACOS-nacos存储, 默认LOCAL
     */
    private String mode = I18NMessageMode.LOCAL;
    /**
     * International file directory, default i18n/
     */
    private String baseFolder = "i18n/";

    /**
     * International file name
     */
    private String basename;

    /**
     * International Code, default utf-8
     */
    private String encoding = StandardCharsets.UTF_8.name();

    /**
     * Cache refresh time, default 5000
     */
    private long cacheMillis = 5000;

    /**
     * Namespace
     */
    private String namespace;
    /**
     * server address
     */
    private String serverAddress;
    /**
     * nacos group
     */
    private String group;
}
