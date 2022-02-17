package com.philosopherzb.i18n.client.advice.ecxeption;

/**
 * @author philosopherZB
 * @date 2021/4/7
 */
public enum BizErrorCode implements ErrorCode{
    /*成功*/
    SUCCESS(200, "success"),
    SYSTEM_BUSY(500, "系统繁忙"),

    PARAM_VALID_EXCEPTION(10001, "参数错误"),
    ;
    private Integer code;

    private String errorMessage;

    BizErrorCode(Integer code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
