package com.qinweizhao.component.core.response;

/**
 * @author qinweizhao
 * @since 2022/4/22
 */
public enum SystemResultCodeEnum implements ResultCode {

    /**
     * 成功
     */
    SUCCESS("200", "成功"),

    /**
     * 参数错误
     */
    BAD_REQUEST("400", "错误的请求"),

    /**
     * 未认证
     */
    UNAUTHORIZED("401", "未认证"),

    /**
     * 未授权
     */
    FORBIDDEN("403", "未授权"),

    /**
     * 未找到
     */
    NOT_FOUND("404", "未找到"),

    /**
     * 异常
     */
    SERVER_ERROR("500", "系统异常,请联系管理员");


    private final String code;

    private final String message;

    SystemResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
