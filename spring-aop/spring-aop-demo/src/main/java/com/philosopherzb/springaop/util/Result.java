package com.philosopherzb.springaop.util;

import lombok.Data;

/**
 * author: philosopherZB
 * date: 2019/12/25
 */
@Data
public class Result {
    private String code;

    private String message;

    private String data;

    public static Result newSuccess(String data){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static Result newFailure(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }
}
