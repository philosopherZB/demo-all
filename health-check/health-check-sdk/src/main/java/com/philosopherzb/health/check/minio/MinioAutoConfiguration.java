package com.philosopherzb.health.check.minio;

import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @author philosopherZB
 * @date 2022/3/22
 */
@EnableConfigurationProperties(MinioHealthProperties.class)
@ConditionalOnProperty(prefix = "health.check.minio", value = "enabled", havingValue = "true")
public class MinioAutoConfiguration {

    @Resource
    private MinioHealthProperties minioHealthProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledHealthIndicator("minio")
    public MinioHealthIndicator minioHealthIndicator() {
        return new MinioHealthIndicator(minioHealthProperties);
    }
}
