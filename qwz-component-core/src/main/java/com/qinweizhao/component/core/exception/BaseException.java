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

    public BaseException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public BaseException(ResultCode resultCode, Throwable e) {
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
}
