package com.qinweizhao.component.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.component.modle.request.PageParam;
import com.qinweizhao.component.mybatis.toolkit.PageUtils;

/**
 * 所有的 Mapper接口 都需要继承当前接口 如果想自己定义其他的全局方法， 您的全局 BaseMapper 需要继承当前接口
 *
 * @author qinweizhao
 */
public interface QwzBaseMapper<T> extends BaseMapper<T> {

    /**
     * 根据 PageParam 生成一个 IPage 实例
     *
     * @param pageParam 分页参数
     * @param <V>       返回的 Record 对象
     * @return IPage<V>
     */
    default <V> IPage<V> prodPage(PageParam pageParam) {
        return PageUtils.prodPage(pageParam);
    }


}