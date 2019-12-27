package com.philosopherzb.springaop.config;

import com.philosopherzb.springaop.interceptor.InterceptorService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * author: philosopherZB
 * date: 2019/12/26
 */
@Configuration
public class WebInterceptorConfig implements WebMvcConfigurer {
    @Resource
    private InterceptorService interceptorService;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(interceptorService).addPathPatterns("/api/v1/**");
    }
}
