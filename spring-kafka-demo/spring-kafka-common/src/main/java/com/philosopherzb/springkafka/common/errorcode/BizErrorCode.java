package com.philosopherzb.springkafka.common.errorcode;

import lombok.Getter;

/**
 * @author philosopherZB
 * @date 2021/4/7
 */
@Getter
public enum BizErrorCode {
    /*成功*/
    SUCCESS(200, "success"),
    SYSTEM_BUSY(500, "系统繁忙"),

    Test_EXCEPTION(10001, "测试异常"),
    ;
    private Integer code;

    private String errorMessage;

    BizErrorCode(Integer code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }
}
