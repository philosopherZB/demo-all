package com.philosopherzb.secret.service.gateway.config;

import com.philosopherzb.secret.service.gateway.interceptor.SignInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author philosopherZB
 * @date 2022/2/10
 */
@Component
public class WebAppConfigurer implements WebMvcConfigurer {
    @Resource
    private SignInterceptor signInterceptor;

    /**
     * 拦截器的配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(signInterceptor).addPathPatterns("/api/security/getSecretKey");
    }
}
