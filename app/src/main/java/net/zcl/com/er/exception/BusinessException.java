package net.zcl.com.er.exception;

/**
 * Created by petrindc on 25.06.2018.
 */

public class BusinessException extends Exception {

    private int errorCode;

    public BusinessException(int errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public BusinessException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public BusinessException(Throwable cause, int errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    protected BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int errorCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }
}
