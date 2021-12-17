package com.philosopherzb.commonutil.i18n.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * International configuration
 *
 * @author philosopherZB
 * @date 2021/12/15
 */
@Data
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "spring.messages")
public class MessageConfig {
    /**
     * International file directory
     */
    private String baseFolder;

    /**
     * International file name
     */
    private String basename;

    /**
     * International Code
     */
    private String encoding;

    /**
     * Cache refresh time
     */
    private long cacheMillis;
}
