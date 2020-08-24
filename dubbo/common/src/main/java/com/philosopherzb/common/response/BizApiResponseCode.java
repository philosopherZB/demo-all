package com.philosopherzb.common.response;

import lombok.Getter;

/**
 * author: philosopherZB
 * date: 2020/8/21
 */
@Getter
public enum BizApiResponseCode {
    SUCCESS("0000", "成功"),
    SYSTEM_BUSY("100001", "系统繁忙"),
    INVALID_PARAM("100002", "请求参数非法"),
    ;

    private String code;

    private String message;

    BizApiResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
