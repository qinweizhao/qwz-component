package com.qinweizhao.component.core.response;


import java.io.Serializable;

/**
 * 统一响应消息报文
 *
 * @param <T> 　T对象
 * @author qinweizhao
 * @since 2022/4/12
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String message;

    private T data;

    /**
     * 私有化构造函数
     */
    private Result() {

    }


    /**
     * 成功-携带数据的响应
     *
     * @param data data
     * @param <T>  T
     * @return R
     */
    public static <T> Result<T> success(T data) {
        return restResult(ResultCodeEnum.SUCCESS.getCode(), data, ResultCodeEnum.SUCCESS.getMessage());
    }

    /**
     * 成功-携带数据和消息的响应
     *
     * @param data    data
     * @param message message
     * @param <T>     T
     * @return R
     */
    public static <T> Result<T> success(T data, String message) {
        return restResult(ResultCodeEnum.SUCCESS.getCode(), data, message);
    }

    /**
     * 失败-携带错误码和错误消息的响应
     *
     * @param code    code
     * @param message message
     * @param <T>     T
     * @return R
     */
    public static <T> Result<T> failure(String code, String message) {
        return restResult(code, null, message);
    }

    /**
     * 失败-携带 ResultCode
     *
     * @param resultCode resultCode
     * @param <T>        T
     * @return R
     */
    public static <T> Result<T> failure(ResultCode resultCode) {
        if (resultCode == null) {
            return new Result<>();
        }
        return restResult(resultCode.getCode(), null, resultCode.getMessage());
    }

    /**
     * restResult
     *
     * @param code    code
     * @param data    data
     * @param message message
     * @param <T>     T
     * @return R
     */
    private static <T> Result<T> restResult(String code, T data, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setMessage(message);
        return result;
    }


    /**
     * getter setter
     *
     * @return public
     */
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
