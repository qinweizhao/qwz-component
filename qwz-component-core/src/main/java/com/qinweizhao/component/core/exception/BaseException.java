package com.qinweizhao.component.core.exception;


import com.qinweizhao.component.core.response.ResultCode;

/**
 * @author qinweizhao
 * @since 2022/4/18
 */
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String message;

    private final String code;

    protected BaseException(String message, String code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    protected BaseException(String message, String code, Throwable e) {
        super(message, e);
        this.message = message;
        this.code = code;
    }

    protected <T extends ResultCode> BaseException(T resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    protected <T extends ResultCode> BaseException(T resultCode, Throwable e) {
        super(resultCode.getMessage(), e);
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public String getResultCode() {
        return code;
    }


}
