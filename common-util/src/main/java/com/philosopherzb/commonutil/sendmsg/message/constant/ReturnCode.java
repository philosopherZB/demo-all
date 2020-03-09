package com.philosopherzb.commonutil.sendmsg.message.constant;

import lombok.Getter;

/**
 * author: philosopherZB
 * date: 2020/3/9
 */
@Getter
public enum ReturnCode {

    RESULT_SUCCESS(0, "success"),
    RESULT_FAIL(401, "系统服务异常"),
    RESULT_SYSTEM_BUSY(402, "系统繁忙");

    private int code;

    private String message;

    ReturnCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
