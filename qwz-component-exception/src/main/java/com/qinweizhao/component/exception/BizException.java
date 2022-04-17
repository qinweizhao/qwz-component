package com.qinweizhao.component.exception;

import cn.hutool.core.util.StrUtil;
import com.qinweizhao.component.exception.base.BaseException;
import com.qinweizhao.component.modle.result.ResultCode;

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

    public BizException(ResultCode resultCode, Object... args) {
        this(resultCode.getCode(), StrUtil.format(resultCode.getMessage(), args));
    }

    public BizException(ResultCode resultCode, Throwable e) {
        super(resultCode, e);
    }


    public BizException(ResultCode resultCode, Throwable e, Object... args) {
        this(resultCode.getCode(), StrUtil.format(resultCode.getMessage(), args), e);
    }

    public BizException(int code, String message) {
        super(code, message);

    }

    public BizException(int code, String message, Throwable e) {
        super(code, message, e);
    }

}