package com.qinweizhao.component.modle.result;


import java.io.Serializable;

/**
 * 统一响应消息报文
 *
 * @param <T> 　T对象
 * @author qinweizhao
 */
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;


    private String code;

    private String message;

    private T data;

    /**
     * 私有化构造函数
     */
    private R() {

    }

    /**
     * 成功-快速响应
     *
     * @param <T> T
     * @return R
     */
    public static <T> R<T> success() {
        return restResult(ResultCodeEnum.SUCCESS.getCode(), null, ResultCodeEnum.SUCCESS.getMessage());
    }

    /**
     * 成功-携带数据的响应
     *
     * @param data data
     * @param <T>  T
     * @return R
     */
    public static <T> R<T> success(T data) {
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
    public static <T> R<T> success(T data, String message) {
        return restResult(ResultCodeEnum.SUCCESS.getCode(), data, message);
    }

    /**
     * 失败-快速响应
     *
     * @param <T> T
     * @return R
     */
    public static <T> R<T> failure() {
        return restResult(ResultCodeEnum.FAILED.getCode(), null, ResultCodeEnum.FAILED.getMessage());
    }


    /**
     * 失败-携带错误消息的响应
     *
     * @param message message
     * @param <T>     T
     * @return R
     */
    public static <T> R<T> failure(String message) {
        return restResult(ResultCodeEnum.FAILED.getCode(), null, message);
    }

    /**
     * 失败-携带错误码和错误消息的响应
     *
     * @param code    code
     * @param message message
     * @param <T>     T
     * @return R
     */
    public static <T> R<T> failure(String code, String message) {
        return restResult(code, null, message);
    }

    /**
     * 失败-携带 ResultCode
     *
     * @param resultCode resultCode
     * @param <T>        T
     * @return R
     */
    public static <T> R<T> failure(ResultCode resultCode) {
        if (resultCode == null) {
            return new R<>();
        }
        return restResult(resultCode.getCode(), null, resultCode.getMessage());
    }

    /**
     * 判断是否成功
     *
     * @param flag flag
     * @param <T>  T
     * @return R
     */
    public static <T> R<T> condition(boolean flag) {
        return flag ? success() : failure();
    }

    /**
     * 判断是否成功
     *
     * @param flag       flag
     * @param resultCode resultCode
     * @param <T>        T
     * @return R
     */
    public static <T> R<T> condition(boolean flag, ResultCode resultCode) {
        return flag ? success() : failure(resultCode);
    }


    /**
     * 判断是否成功
     *
     * @param count flag
     * @param <T>   T
     * @return R
     */
    public static <T> R<T> condition(int count) {
        return count > 0 ? success() : failure();
    }

    /**
     * 判断是否成功
     *
     * @param count      flag
     * @param resultCode resultCode
     * @param <T>        T
     * @return R
     */
    public static <T> R<T> condition(int count, ResultCode resultCode) {
        return count > 0 ? success() : failure(resultCode);
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
    private static <T> R<T> restResult(String code, T data, String message) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setData(data);
        r.setMessage(message);
        return r;
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
