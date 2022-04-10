package com.qinweizhao.modle.result;


import java.util.HashMap;

/**
 * 操作消息提醒
 *
 * @author qinweizhao
 */
public class SimpleResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int SUCCESS = 200;
    /**
     * 失败
     */
    public static final int FAILURE = 500;

    /**
     * 状态码
     */
    public static final String CODE_TAG = "code";
    /**
     * 返回内容
     */
    public static final String MSG_TAG = "msg";
    /**
     * 数据对象
     */
    public static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的 AjaxResult 对象，使其表示一个空消息。
     */
    public SimpleResult() {
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     */
    public SimpleResult(int code, String msg) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }

    /**
     * 初始化一个新创建的 AjaxResult 对象
     *
     * @param code 状态码
     * @param msg  返回内容
     * @param data 数据对象
     */
    public SimpleResult(int code, String msg, Object data) {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (data != null) {
            super.put(DATA_TAG, data);
        }
    }

    /**
     * 返回成功消息
     *
     * @return 成功消息
     */
    public static SimpleResult success() {
        return SimpleResult.success("操作成功");
    }

    /**
     * 返回成功数据
     *
     * @return 成功消息
     */
    public static SimpleResult success(Object data) {
        return SimpleResult.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static SimpleResult success(String msg) {
        return SimpleResult.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static SimpleResult success(String msg, Object data) {
        return new SimpleResult(SUCCESS, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @return
     */
    public static SimpleResult error() {
        return SimpleResult.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static SimpleResult error(String msg) {
        return SimpleResult.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static SimpleResult error(String msg, Object data) {
        return new SimpleResult(FAILURE, msg, data);
    }

    /**
     * 返回错误消息
     *
     * @param code 状态码
     * @param msg  返回内容
     * @return 警告消息
     */
    public static SimpleResult error(int code, String msg) {
        return new SimpleResult(code, msg, null);
    }

    /**
     * 方便链式调用
     *
     * @param key   key
     * @param value value
     * @return
     */
    @Override
    public SimpleResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
