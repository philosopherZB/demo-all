package com.philosopherzb.gateway.interceptor;


import com.alibaba.fastjson.JSON;
import com.philosopherzb.common.response.GateWayApiResponse;
import com.philosopherzb.common.response.GateWayApiResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * author: philosopherZB
 * date: 2020/7/1
 */
@Component
@Slf4j
public class SessionInterceptor extends HandlerInterceptorAdapter {

    private static final List<String> API_SESSION = new ArrayList<>();

    static {
        API_SESSION.add("/api/member/card/alipay/create");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        response.setCharacterEncoding("UTF-8");
        String origin = request.getHeader("origin");
        response.setHeader("Access-Control-Allow-Origin", StringUtils.isEmpty(origin) ? "*" : origin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setContentType("application/json;charset=UTF-8");

        String uri = request.getRequestURI();
        log.info("SessionInterceptor, requestUri:{}, Is it necessary to verify:{}", uri, API_SESSION.contains(uri));

        // 排查日志
        log.info("SessionInterceptor, sessionId:{}", request.getSession().getId());

        if (API_SESSION.contains(uri)) {
            String session = (String) request.getSession().getAttribute("SESSION_KEY");
            if (StringUtils.isBlank(session)) {
                log.info("SessionInterceptor, session is null, return NOT_AUTH_ERROR");
                responseToH5(response, GateWayApiResponseCode.SERVICE_INTERNAL_ERROR);
                return false;
            }
        }
        return true;
    }

    /**
     * 返回给h5
     *
     * @param response   返回信息
     * @param returnCode 错误码
     * @throws IOException 异常
     */
    private void responseToH5(HttpServletResponse response, GateWayApiResponseCode returnCode) throws IOException {
        GateWayApiResponse result = GateWayApiResponse.newFailure(returnCode);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(JSON.toJSONString(result));
    }
}
