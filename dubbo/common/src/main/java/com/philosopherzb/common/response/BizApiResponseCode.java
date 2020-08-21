package com.philosopherzb.common.response;

import lombok.Getter;

/**
 * author: philosopherZB
 * date: 2020/8/21
 */
@Getter
public enum BizApiResponseCode {
    SUCCESS("0000", "成功"),
    ;

    private String code;

    private String message;

    BizApiResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
