package com.qinweizhao.component.log.service;

import com.qinweizhao.component.log.SysOperLog;
import com.qinweizhao.component.util.constant.SecurityConstants;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 异步调用日志服务
 *
 * @author qinweizhao
 */
@Service
public class AsyncLogService {

    @Resource
    private QwzLogService qwzLogService;

    /**
     * 保存系统日志记录
     */
    @Async
    public void saveSysLog(SysOperLog sysOperLog) {
        qwzLogService.saveLog(sysOperLog, SecurityConstants.INNER);
    }
}
