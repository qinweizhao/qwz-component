package com.qinweizhao.component.modle.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 实体类基类
 *
 * @author qinweizhao
 */
public abstract class BaseEntity implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * 创建者
     */
    private Integer createBy;

    /**
     * 更新者
     */
    private Integer updateBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
