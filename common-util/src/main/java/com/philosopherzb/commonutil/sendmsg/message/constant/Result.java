package com.philosopherzb.commonutil.sendmsg.message.constant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * author: philosopherZB
 * date: 2020/3/9
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -115654821190105534L;

    private int result;
    private String message;
    private T data;

    private Result() {
    }

    public static <T> Result<T> newFailure(ReturnCode returnCode) {
        Result<T> result = new Result<>();

        result.setResult(returnCode.getCode());
        result.setMessage(returnCode.getMessage());
        result.data = null;

        return result;
    }

    public static <T> Result<T> newSuccess() {
        return newSuccess(null);
    }

    public static <T> Result<T> newSuccess(T data) {
        Result<T> result = new Result<>();

        result.setResult(ReturnCode.RESULT_SUCCESS.getCode());
        result.setMessage(ReturnCode.RESULT_SUCCESS.getMessage());
        result.data = data;

        return result;
    }
}
