package com.philosopherzb.gateway.handler;

import com.philosopherzb.common.response.GateWayApiResponse;
import com.philosopherzb.common.response.GateWayApiResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author: philosopherZB
 * date: 2020/8/21
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public GateWayApiResponse handleBizException(Exception e) {
        log.error("service occurs error,error={}", e);
        return GateWayApiResponse.newFailure(GateWayApiResponseCode.SERVICE_INTERNAL_ERROR);
    }
}
