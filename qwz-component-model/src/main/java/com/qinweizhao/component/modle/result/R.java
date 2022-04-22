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

    /**
     * 成功
     */
    public static final String SUCCESS = "200";
    /**
     * 失败
     */
    public static final String FAILURE = "500";

    private String code;

    private String msg;

    private T data;

    private R() {

    }

    private R(ResultCode resultCode) {
        restResult(resultCode.getCode(), null, resultCode.getMessage());
    }

    private R(ResultCode resultCode, T data) {
        restResult(resultCode.getCode(), data, resultCode.getMessage());
    }


    public static <T> R<T> success() {
        return new R<>();
    }

    public static <T> R<T> success(T data) {
        return restResult(SUCCESS, data, null);
    }

    public static <T> R<T> success(ResultCode resultCode) {
        return new R<>(resultCode, null);
    }

    public static <T> R<T> success(ResultCode resultCode, T data) {
        return new R<>(resultCode, data);
    }

    public static <T> R<T> success(T data, String msg) {
        return restResult(SUCCESS, data, msg);
    }


    public static <T> R<T> failure() {
        return restResult(FAILURE, null, null);
    }

    public static <T> R<T> failure(ResultCode resultCode) {
        return new R<>(resultCode);
    }

    public static <T> R<T> failure(String msg) {
        return restResult(FAILURE, null, msg);
    }

    public static <T> R<T> failure(T data, String msg) {
        return restResult(FAILURE, data, msg);
    }


    public static <T> R<T> condition(boolean flag) {
        return flag ? success() : failure();
    }

    public static <T> R<T> condition(int i) {
        return i > 0 ? success() : failure();
    }


    private static <T> R<T> restResult(String code, T data, String msg) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
