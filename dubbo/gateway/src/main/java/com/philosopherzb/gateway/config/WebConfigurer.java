package com.philosopherzb.gateway.config;

import com.philosopherzb.gateway.interceptor.CorsInterceptor;
import com.philosopherzb.gateway.interceptor.ParamCheckInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * author: philosopherZB
 * date: 2020/8/20
 */
@Component
public class WebConfigurer implements WebMvcConfigurer {

    @Resource
    private CorsInterceptor corsInterceptor;
    @Resource
    private ParamCheckInterceptor paramCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
        registry.addInterceptor(paramCheckInterceptor).addPathPatterns("/**");
    }

    // 此处实现跨域，可以省去一个拦截器CorsInterceptor
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE");
    }
}
