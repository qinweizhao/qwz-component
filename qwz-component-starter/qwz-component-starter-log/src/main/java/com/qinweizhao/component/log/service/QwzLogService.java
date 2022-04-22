package com.qinweizhao.component.log.service;

import com.qinweizhao.component.log.SysOperLog;

/**
 * @author qinweizhao
 * @since 2022/4/16
 */
public interface QwzLogService {


    /**
     * 保存日志
     *
     * @param sysOperLog sysOperLog
     * @param inner      inner
     */
    void saveLog(SysOperLog sysOperLog, String inner);
}
