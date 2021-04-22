package com.philosopherzb.springkafka.common.exception;

import com.philosopherzb.springkafka.common.errorcode.BizErrorCode;
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

    private BizErrorCode bizErrorCode;

    public BizException() {
        super(BizErrorCode.SUCCESS.getErrorMessage());
        this.bizErrorCode = BizErrorCode.SUCCESS;
    }

    public BizException(BizErrorCode bizErrorCode) {
        super(bizErrorCode.getErrorMessage());
        this.bizErrorCode = bizErrorCode;
    }

    public BizException(BizErrorCode bizErrorCode, String message) {
        super(message);
        this.bizErrorCode = bizErrorCode;
    }
}
