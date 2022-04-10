package com.qinweizhao.modle.result;


import java.io.Serializable;

/**
 * 统一响应消息报文
 *
 * @param <T> 　T对象
 * @author qinweizhao
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int SUCCESS = 200;
    /**
     * 失败
     */
    public static final int FAILURE = 500;

    private int code;

    private String msg;

    private long time;

    private T data;

    private Result() {

    }

    private Result(IResultCode resultCode) {
        restResult(resultCode.getCode(), null, resultCode.getMsg());
    }

    private Result(IResultCode resultCode, T data) {
        restResult(resultCode.getCode(), data, resultCode.getMsg());
    }


    public static <T> Result<T> success() {
        return new Result<>();
    }

    public static <T> Result<T> success(T data) {
        return restResult(SUCCESS, data, null);
    }

    public static <T> Result<T> success(IResultCode resultCode) {
        return new Result<>(resultCode, null);
    }

    public static <T> Result<T> success(IResultCode resultCode, T data) {
        return new Result<>(resultCode, data);
    }

    public static <T> Result<T> success(T data, String msg) {
        return restResult(SUCCESS, data, msg);
    }


    public static <T> Result<T> failure() {
        return restResult(FAILURE, null, null);
    }

    public static <T> Result<T> failure(IResultCode resultCode) {
        return new Result<>(resultCode);
    }

    public static <T> Result<T> failure(String msg) {
        return restResult(FAILURE, null, msg);
    }

    public static <T> Result<T> failure(T data, String msg) {
        return restResult(FAILURE, data, msg);
    }


    public static <T> Result<T> condition(boolean flag) {
        return flag ? success() : failure();
    }

    public static <T> Result<T> condition(int i) {
        return i > 0 ? success() : failure();
    }


    private static <T> Result<T> restResult(int code, T data, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        result.setTime(System.currentTimeMillis());
        return result;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
