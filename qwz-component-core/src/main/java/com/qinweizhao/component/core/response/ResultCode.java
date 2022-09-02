package com.qinweizhao.component.core.response;

/**
 * @author qinweizhao
 * @since 2022/4/12
 */
public interface ResultCode {

    /**
     * 获取业务码
     *
     * @return 业务码
     */
    String getCode();

    /**
     * 获取信息
     *
     * @return 返回结构体中的信息
     */
    String getMessage();


}
