package com.philosopherzb.gateway.interceptor;

import com.alibaba.fastjson.JSON;
import com.philosopherzb.common.response.GateWayApiResponse;
import com.philosopherzb.common.response.GateWayApiResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * author: philosopherZB
 * date: 2020/9/3
 */
@Slf4j
@Component
public class RateLimitInterceptor extends HandlerInterceptorAdapter {

    private static final List<String> RATE_LIMIT_API = new ArrayList<>();

    static {
        RATE_LIMIT_API.add("/api/member/card/alipay/create");
    }

    @Resource
    RedisTemplate<String, Long> redisTemplate;
    @Resource
    DefaultRedisScript<Long> redisLuaScript;
    @Resource
    private RedissonClient redissonClient;

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
        log.info("RateLimitInterceptor, requestUri:{}, Is it necessary to rateLimit:{}", uri, RATE_LIMIT_API.contains(uri));

        if (RATE_LIMIT_API.contains(uri)) {
            String session = (String) request.getSession().getAttribute("SESSION_KEY");
            if (StringUtils.isNotBlank(session)) {
                // lua限流
//                List<String> keys = Collections.singletonList("session_userId");
//                log.info("RateLimitInterceptor, session is not null, to rateLimit");
//                Long rateLimitResult = redisTemplate.execute(redisLuaScript, keys, new ArrayList<>(), new ArrayList<>());
//                if (rateLimitResult == null || rateLimitResult == 0) {
//                    responseToH5(response, GateWayApiResponseCode.SERVICE_INTERNAL_ERROR);
//                    return false;
//                }
                // redisson限流
                RRateLimiter rateLimiter = redissonClient.getRateLimiter("session_userId");
                // PER_CLIENT每个客户端单独计算流量，每10秒产生1个令牌
                rateLimiter.trySetRate(RateType.PER_CLIENT, 1L, 10L, RateIntervalUnit.SECONDS);
                if (!rateLimiter.tryAcquire()) {
                    responseToH5(response, GateWayApiResponseCode.SERVICE_INTERNAL_ERROR);
                    return false;
                }
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
