package com.philosopherzb.commonutil.i18n.advice.result;

import com.philosopherzb.commonutil.i18n.advice.ecxeption.BizErrorCode;
import com.philosopherzb.commonutil.i18n.advice.ecxeption.ErrorCode;

/**
 * @author philosopherZB
 * @date 2021/4/2
 */
public class ResultUtils {

    /**
     * 成功结果集
     *
     * @param data 返回数据
     * @param <T>  泛型
     * @return 成功结果集
     */
    public static <T> Result<T> successResult(T data) {
        return new Result<T>(BizErrorCode.SUCCESS.getCode(), BizErrorCode.SUCCESS.getErrorMessage(), data);
    }

    /**
     * 失败结果集
     *
     * @param errorCode 指定错误枚举类
     * @param <T>       泛型
     * @return 失败结果集
     */
    public static <T> Result<T> failResult(ErrorCode errorCode) {
        return failResult(errorCode.getCode(), errorCode.getErrorMessage());
    }

    /**
     * 失败结果集
     *
     * @param errorCode 错误码
     * @param errorMsg  错误消息
     * @param <T>       泛型
     * @return 失败结果集
     */
    public static <T> Result<T> failResult(Integer errorCode, String errorMsg) {
        return new Result<T>(errorCode, errorMsg);
    }
}
