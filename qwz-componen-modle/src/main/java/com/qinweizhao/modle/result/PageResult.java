package com.qinweizhao.modle.result;


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
    protected List<T> records = Collections.emptyList();

    /**
     * 总数
     */
    protected Long total = 0L;

    public PageResult() {
    }

    public PageResult(long total) {
        this.total = total;
    }

    public PageResult(List<T> records, long total) {
        this.records = records;
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
