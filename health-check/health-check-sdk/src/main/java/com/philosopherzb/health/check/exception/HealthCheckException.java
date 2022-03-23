package com.philosopherzb.health.check.exception;

/**
 * @author philosopherZB
 * @date 2022/3/22
 */
public class HealthCheckException extends RuntimeException {
    private static final long serialVersionUID = -1777242797922817714L;

    public HealthCheckException() {

    }

    public HealthCheckException(String message) {
        super(message);
    }

    public HealthCheckException(Throwable cause) {
        super(cause);
    }

    public HealthCheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public HealthCheckException(String message, Throwable cause,
                                boolean enableSuppression,
                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
