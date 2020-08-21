package com.philosopherzb.gateway.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author: philosopherZB
 * date: 2020/6/29
 */
@Slf4j
@Component
public class CorsInterceptor extends HandlerInterceptorAdapter {

    /**
     * options请求
     */
    private static final String OPTIONS_METHOD = "OPTIONS";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        log.info("CorsInterceptor.preHandle ==========>");
        response.setCharacterEncoding("UTF-8");
        String origin = request.getHeader("origin");
        response.setHeader("Access-Control-Allow-Origin", StringUtils.isEmpty(origin) ? "*" : origin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setContentType("application/json;charset=UTF-8");

        // options请求直接返回200
        if (OPTIONS_METHOD.equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpStatus.OK.value());
            return false;
        }
        return true;
    }
}
