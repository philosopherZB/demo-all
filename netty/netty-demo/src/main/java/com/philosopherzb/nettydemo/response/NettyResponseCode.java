package com.philosopherzb.nettydemo.response;

import lombok.Getter;

/**
 * 关于验码错误码的定义，0表示成功，0-90000表示重试（慎重使用，可能会打爆服务），90000以上表示不重试。
 * author: philosopherZB
 * date: 2020/5/9
 */
@Getter
public enum NettyResponseCode {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),
    /**
     * 在线验码失败
     */
    CHECK_QR_CODE_FAIL_ON_LINE(90001, "在线验码失败"),
    /**
     * 系统异常
     */
    SYSTEM_ERROR(90002, "系统异常"),
    /**
     * 验签失败
     */
    CHECK_SIGNATURE_FAILED(90003, "报文验签失败"),

    ;

    /**
     * 错误码
     */
    private Integer code;
    /**
     * 错误信息描述
     */
    private String msg;

    NettyResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
