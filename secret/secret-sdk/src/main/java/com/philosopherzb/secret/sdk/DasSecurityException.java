package com.philosopherzb.secret.sdk;

/**
 * @author philosopherZB
 * @date 2022/1/17
 */
public class DasSecurityException extends Exception {
    private static final long serialVersionUID = -6922485851359629846L;

    public DasSecurityException() {
        super();
    }

    public DasSecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    public DasSecurityException(String message) {
        super(message);
    }

    public DasSecurityException(Throwable cause) {
        super(cause);
    }
}
