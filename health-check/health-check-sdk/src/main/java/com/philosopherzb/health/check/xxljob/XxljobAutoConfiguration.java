package com.philosopherzb.health.check.xxljob;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
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
@EnableConfigurationProperties(XxlJobHealthProperties.class)
@ConditionalOnProperty(prefix = "health.check.xxljob", value = "enabled", havingValue = "true")
public class XxljobAutoConfiguration {

    @Resource
    private XxlJobHealthProperties xxlJobHealthProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledHealthIndicator("xxljob")
    public XxljobHealthIndicator xxljobHealthIndicator() {
        return new XxljobHealthIndicator(xxlJobHealthProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    public XxlJobSpringExecutor xxlJobExecutor() {
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(xxlJobHealthProperties.getAdminAddresses());
        xxlJobSpringExecutor.setAppname(xxlJobHealthProperties.getAppname());
        xxlJobSpringExecutor.setAddress(xxlJobHealthProperties.getAddress());
        xxlJobSpringExecutor.setIp(xxlJobHealthProperties.getIp());
        xxlJobSpringExecutor.setPort(xxlJobHealthProperties.getPort());
        xxlJobSpringExecutor.setAccessToken(xxlJobHealthProperties.getAccessToken());
        xxlJobSpringExecutor.setLogPath(xxlJobHealthProperties.getLogPath());
        xxlJobSpringExecutor.setLogRetentionDays(xxlJobHealthProperties.getLogRetentionDays());

        return xxlJobSpringExecutor;
    }
}
