package com.philosopherzb.commonutil.i18n.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

/**
 * International configuration
 *
 * @author philosopherZB
 * @date 2021/12/15
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.messages")
public class MessageConfig {
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
