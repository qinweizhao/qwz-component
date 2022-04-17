package com.qinweizhao.component.exception.base;

import cn.hutool.core.util.StrUtil;
import com.qinweizhao.component.modle.result.ResultCode;

/**
 * @author qinweizhao
 * @since 2022/4/18
 */
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String message;

    private final int code;


    public BaseException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }


    public BaseException(ResultCode resultCode, Object... args) {
        this(resultCode.getCode(), StrUtil.format(resultCode.getMessage(), args));
    }

    public BaseException(ResultCode resultCode, Throwable e) {
        super(resultCode.getMessage(), e);
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public BaseException(ResultCode resultCode, Throwable e, Object... args) {
        this(resultCode.getCode(), StrUtil.format(resultCode.getMessage(), args), e);
    }

    public BaseException(int code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public BaseException(int code, String message, Throwable e) {
        super(message, e);
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
