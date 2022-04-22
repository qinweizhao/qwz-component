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
    public static final String SUCCESS = "00000";

    private String code;

    private String msg;

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
        return restResult(SUCCESS, null, "OK");
    }

    /**
     * 成功-携带数据的响应
     *
     * @param data data
     * @param <T>  T
     * @return R
     */
    public static <T> R<T> success(T data) {
        return restResult(SUCCESS, data, "OK");
    }

    /**
     * 失败-携带 ResultCode（强制统一管理错误码）
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
     * @param flag       flag
     * @param resultCode resultCode
     * @param <T>        T
     * @return R
     */
    public static <T> R<T> condition(boolean flag, ResultCode resultCode) {
        return flag ? success() : failure(resultCode);
    }

    public static <T> R<T> condition(boolean flag) {
        return flag ? success() : failure(null);
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

    public static <T> R<T> condition(int count) {
        return count > 0 ? success() : failure(null);
    }


    /**
     * restResult
     *
     * @param code code
     * @param data data
     * @param msg  msg
     * @param <T>  T
     * @return R
     */
    private static <T> R<T> restResult(String code, T data, String msg) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
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
