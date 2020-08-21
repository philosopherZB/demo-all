package com.philosopherzb.common.response;

import lombok.Getter;

/**
 * author: philosopherZB
 * date: 2020/8/21
 * 网关枚举值
 */
@Getter
public enum GateWayApiResponseCode {
    SUCCESS("0000", "成功"),
    SERVICE_INTERNAL_ERROR("100001", "服务调用出错"),
    REQUIRED_PARAMS_MISSING("100002", "必填字段缺失"),
    BIZ_SYSTEM_RETURN_ERROR("100003", "业务系统返回错误，详见业务错误码"),
    ;

    private String code;

    private String message;

    GateWayApiResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
