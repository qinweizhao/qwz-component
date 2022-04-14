package com.qinweizhao.component.exception;

import com.qinweizhao.component.exception.base.BaseException;

/**
 * BizException 是已知异常，无需重试
 *
 * @author qinweizhao
 * @since 2022/4/12
 */
public class BizException extends BaseException {

    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_ERR_CODE = "BIZ_ERROR";

    public BizException(String errMessage) {
        super(DEFAULT_ERR_CODE, errMessage);
    }

    public BizException(String errCode, String errMessage) {
        super(errCode, errMessage);
    }

    public BizException(String errMessage, Throwable e) {
        super(DEFAULT_ERR_CODE, errMessage, e);
    }

    public BizException(String errorCode, String errMessage, Throwable e) {
        super(errorCode, errMessage, e);
    }

}