package com.qinweizhao.component.core.request;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询参数
 *
 * @author qinweizhao
 * @since 2022/4/12
 */
public abstract class PageParam implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String ASC = "ASC";

    public static final String DESC = "DESC";

    private static final int DEFAULT_PAGE_SIZE = 10;

    private int pageSize = DEFAULT_PAGE_SIZE;

    private int pageNum = 1;

    private String orderDirection = DESC;

    private String groupBy;

    private boolean needTotalCount = true;


    private List<PageParam.Sort> sorts = new ArrayList<>();

    public static class Sort {

        /**
         * 属性
         */
        private String field;

        /**
         * 是否正序排序
         */
        private boolean asc;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public boolean isAsc() {
            return asc;
        }

        public void setAsc(boolean asc) {
            this.asc = asc;
        }
    }

    public List<PageParam.Sort> getSorts() {
        return sorts;
    }

    public void setSorts(List<PageParam.Sort> sorts) {
        this.sorts = sorts;
    }

    public int getPageNum() {
        if (pageNum < 1) {
            return 1;
        }
        return pageNum;
    }

    public PageParam setPageNum(int pageIndex) {
        this.pageNum = pageIndex;
        return this;
    }

    public int getPageSize() {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    public PageParam setPageSize(int pageSize) {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize;
        return this;
    }

    public int getOffset() {
        return (getPageNum() - 1) * getPageSize();
    }

    public String getOrderDirection() {
        return orderDirection;
    }

    public PageParam setOrderDirection(String orderDirection) {
        if (ASC.equalsIgnoreCase(orderDirection) || DESC.equalsIgnoreCase(orderDirection)) {
            this.orderDirection = orderDirection;
        }
        return this;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public boolean isNeedTotalCount() {
        return needTotalCount;
    }

    public void setNeedTotalCount(boolean needTotalCount) {
        this.needTotalCount = needTotalCount;
    }

}
