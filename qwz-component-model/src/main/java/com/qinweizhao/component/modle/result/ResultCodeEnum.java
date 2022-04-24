package com.qinweizhao.component.modle.result;

/**
 * @author qinweizhao
 * @since 2022/4/22
 */
public enum ResultCodeEnum implements ResultCode {

    /**
     * 服务未找到
     */
    NOT_FOUND("404", "服务未找到"),

    /**
     * 返回成功
     */
    SUCCESS("200", "操作成功"),

    /**
     * 系统异常,请稍后再试
     */
    FAILED("500", "系统异常,请稍后再试"),

    /**
     * 参数为空
     */
    BAD_REQUEST("400", "请求异常"),

    /**
     * 用户未认证
     */
    UNAUTHORIZED("401", "用户未认证");


    private final String code;

    private final String message;

    ResultCodeEnum(String code, String message) {
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
