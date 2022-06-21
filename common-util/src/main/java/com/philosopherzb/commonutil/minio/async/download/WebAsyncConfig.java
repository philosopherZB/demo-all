package com.philosopherzb.commonutil.minio.async.download;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author philosopherZB
 * @date 2022/6/21
 */
@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "async.config")
public class WebAsyncConfig implements WebMvcConfigurer {
    //从配置文件中获取
    private int corePoolSize;

    private int maxPoolSize;

    private int queueCapacity;

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(mvcTaskExecutor());
        configurer.setDefaultTimeout(3600_000);
    }

    @Bean
    public ThreadPoolTaskExecutor mvcTaskExecutor() {
        log.info("Creating Async Task Executor...");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix("mvc-async-");
        return executor;
    }
}
