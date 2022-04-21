package com.qinweizhao.component.modle.result;

/**
 * @author qinweizhao
 * @since 2022/4/22
 */
public enum ResultCodeEnum implements ResultCode {

    /**
     * 操作成功
     */
    SUCCESS("200", "操作成功"),

    /**
     * 业务异常
     */
    FAILURE("400", "业务异常"),

    /**
     * 服务未找到
     */
    NOT_FOUND("404", "服务未找到"),

    /**
     * 服务异常
     */
    ERROR("500", "服务异常");


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
