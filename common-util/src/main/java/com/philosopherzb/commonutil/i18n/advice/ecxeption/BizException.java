package com.philosopherzb.commonutil.i18n.advice.ecxeption;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author philosopherZB
 * @date 2021/4/5
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BizException extends RuntimeException {
    private static final long serialVersionUID = -3279511289021480282L;

    private ErrorCode errorCode;

    public BizException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    public BizException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
