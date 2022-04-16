package com.qinweizhao.component.log.service;

import com.qinweizhao.component.log.SysOperLog;
import com.qinweizhao.component.modle.result.R;

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
     * @return Boolean
     */
    R<Boolean> saveLog(SysOperLog sysOperLog, String inner);
}
