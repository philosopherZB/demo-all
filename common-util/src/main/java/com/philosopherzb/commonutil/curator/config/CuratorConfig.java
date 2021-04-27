package com.philosopherzb.commonutil.curator.config;

import lombok.Data;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author philosopherZB
 * @date 2021/4/27
 */
@Data
@Configuration
@ConfigurationProperties(value = "curator")
public class CuratorConfig {

    /**
     * 重试次数
     */
    private Integer retryCount;

    /**
     * 重试间隔时间
     */
    private Integer elapsedTimeMs;

    /**
     * zookeeper 地址
     */
    private String connectString;

    /**
     * session超时时间
     */
    private Integer sessionTimeoutMs;

    /**
     * 连接超时时间
     */
    private Integer connectionTimeoutMs;

    @Bean(initMethod = "start")
    public CuratorFramework curatorFramework() {
        return CuratorFrameworkFactory.newClient(
                connectString,
                sessionTimeoutMs,
                connectionTimeoutMs,
                new RetryNTimes(retryCount, elapsedTimeMs)
        );
    }
}
