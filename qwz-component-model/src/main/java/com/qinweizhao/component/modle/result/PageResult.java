package com.qinweizhao.component.modle.result;


import java.util.Collections;
import java.util.List;

/**
 * 分页返回结果
 *
 * @author qinweizhao
 */
public class PageResult<T> {

    /**
     * 查询数据列表
     */
    protected List<T> rows = Collections.emptyList();

    /**
     * 总数
     */
    protected Long total = 0L;

    public PageResult() {
    }

    public PageResult(long total) {
        this.total = total;
    }

    public PageResult(List<T> rows, long total) {
        this.rows = rows;
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
