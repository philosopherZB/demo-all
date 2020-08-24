package com.philosopherzb.common.exception;

import com.philosopherzb.common.response.BizApiResponseCode;

/**
 * author: philosopherZB
 * date: 2020/8/24
 */
public class BizException extends Exception {
    private static final long serialVersionUID = 7748973512690205553L;

    private BizApiResponseCode errorCode;

    public BizException() {
        super();
    }

    public BizException(BizApiResponseCode errorCode) {
        this.errorCode = errorCode;
    }

    public BizApiResponseCode getErrorCode() {
        return errorCode;
    }

}
