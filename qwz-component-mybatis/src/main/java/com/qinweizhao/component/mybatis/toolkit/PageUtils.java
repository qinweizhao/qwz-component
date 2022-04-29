package com.qinweizhao.component.mybatis.toolkit;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.component.modle.request.PageParam;

import java.util.List;

/**
 * @author qinweizhao
 */
public class PageUtils {

    private PageUtils() {
    }

    /**
     * 根据 PageParam 生成一个 IPage 实例
     *
     * @param pageParam 分页参数
     * @param <V>       返回的 Record 对象
     * @return IPage<V>
     */
    public static <V> IPage<V> prodPage(PageParam pageParam) {
        Page<V> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());
        List<PageParam.Sort> sorts = pageParam.getSorts();
        for (PageParam.Sort sort : sorts) {
            OrderItem orderItem = sort.isAsc() ? OrderItem.asc(sort.getField()) : OrderItem.desc(sort.getField());
            page.addOrder(orderItem);
        }
        return page;
    }

}
