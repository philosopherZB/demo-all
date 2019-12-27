package com.philosopherzb.springaop.util;

import lombok.Getter;

/**
 * author: philosopherZB
 * date: 2019/12/25
 */
@Getter
public enum ResultEnum {

    SUCCESS("0","成功"),
    NOT_FOUND_ERROR("404","未找到相关内容，请检查请求参数"),
    SERVER_ERROR("500","服务器错误，请稍后"),
    SYSTEM_ERROR("10000","系统错误，请稍后"),
    REQUIRED_PARAMETER_MISSING("10001","必填参数缺失");

    private String code;

    private String message;

    ResultEnum(String code, String message){
        this.code = code;
        this.message = message;
    }
}
