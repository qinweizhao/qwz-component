package com.qinweizhao.component.exception;

import com.qinweizhao.component.exception.base.BaseException;

/**
 * 系统异常是意外异常，重试可能会再次起作用
 *
 * @author qinweizhao
 * @since 2022/4/12
 */
public class SysException extends BaseException {

    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_ERR_CODE = "SYS_ERROR";

    public SysException(String errMessage) {
        super(DEFAULT_ERR_CODE, errMessage);
    }

    public SysException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public SysException(String errMessage, Throwable e) {
        super(DEFAULT_ERR_CODE, errMessage, e);
    }

    public SysException(String errorCode, String errMessage, Throwable e) {
        super(errorCode, errMessage, e);
    }

}
