package com.qinweizhao.component.core.exception;

import com.qinweizhao.component.core.response.ResultCode;

/**
 * BizException 业务异常
 *
 * @author qinweizhao
 * @since 2022/4/12
 */
public class BizException extends BaseException {

    public BizException(ResultCode resultCode) {
        super(resultCode);
    }

    public BizException(ResultCode resultCode, Throwable e) {
        super(resultCode, e);
    }

}