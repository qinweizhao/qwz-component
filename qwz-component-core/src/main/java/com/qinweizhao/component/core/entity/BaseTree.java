package com.qinweizhao.component.core.entity;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/7/6
 */
public abstract class BaseTree<T> {

    /**
     * 父 ID
     */
    private Long parentId;

    /**
     * 子元素
     */
    private List<T> children;

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
