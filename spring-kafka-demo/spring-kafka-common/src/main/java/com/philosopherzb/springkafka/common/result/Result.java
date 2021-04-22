package com.philosopherzb.springkafka.common.result;

import lombok.Data;

/**
 * @author philosopherZB
 * @date 2021/4/7
 */
@Data
public class Result<T> {
    /**
     * status
     * 状态码
     */
    private Integer code;

    /**
     * message
     * 消息
     */
    private String msg;

    /**
     * data
     */
    private T data;

    public Result() {
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
