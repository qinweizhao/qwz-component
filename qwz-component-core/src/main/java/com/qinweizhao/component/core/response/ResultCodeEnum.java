package com.qinweizhao.component.core.response;

/**
 * @author qinweizhao
 * @since 2022/4/22
 */
public enum ResultCodeEnum implements ResultCode {


    /*
     * 错误码为字符串类型，共 5 位，分成两个部分：错误产生来源+四位数字编号。
     * 说明：错误产生来源分为 A/B/C，A 表示错误来源于用户，比如参数错误，用户安装版本过低，用户支付
     * 超时等问题；B 表示错误来源于当前系统，往往是业务逻辑出错，或程序健壮性差等问题；C 表示错误来源
     * 于第三方服务，比如 CDN 服务出错，消息投递超时等问题；四位数字编号从 0001 到 9999，大类之间的
     * 步长间距预留 100。
     */


    /**
     * 成功
     */
    SUCCESS("00000", "成功"),

    /**
     * 失败
     */
    FAILURE("9999","失败"),


    /**
     * 一级宏观错误码，错误来源于用户
     */
    USER_ERROR("A0001", "用户端出现错误"),

    /**
     * 一级宏观错误码，错误来源于当前系统
     */
    SERVER_ERROR("B0001", "系统执行出现错误"),

    /**
     * 一级宏观错误码，错误来源于第三方服务
     */
    REMOTE_ERROR("C0001", "调用第三方服务出现错误");


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
