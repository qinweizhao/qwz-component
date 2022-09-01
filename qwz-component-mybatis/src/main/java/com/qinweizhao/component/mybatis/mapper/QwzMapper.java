package com.qinweizhao.component.mybatis.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.qinweizhao.component.core.request.PageParam;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.util.MyBatisUtils;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

/**
 * 所有的 Mapper接口 都需要继承当前接口 如果想自己定义其他的全局方法， 您的全局 BaseMapper 需要继承当前接口
 *
 * @author qinweizhao
 * @since 2022/4/29
 */
public interface QwzMapper<T> extends BaseMapper<T> {

    /**
     * 查询分页信息
     *
     * @param pageParam    pageParam
     * @param queryWrapper queryWrapper
     * @return PageResult
     */
    default PageResult<T> selectPage(PageParam pageParam, @Param("ew") Wrapper<T> queryWrapper) {
        // MyBatis Plus 查询
        IPage<T> mpPage = MyBatisUtils.buildPage(pageParam);
        selectPage(mpPage, queryWrapper);
        // 转换返回
        return new PageResult<>(mpPage.getRecords(), mpPage.getTotal());
    }

    /**
     * 根据 field-value ，查询一条记录
     *
     * @param field field
     * @param value value
     * @return T
     */
    default T selectOne(String field, Object value) {
        return selectOne(new QueryWrapper<T>().eq(field, value));
    }

    /**
     * 根据 field-value ，查询一条记录
     *
     * @param field field
     * @param value value
     * @return T
     */
    default T selectOne(SFunction<T, ?> field, Object value) {
        return selectOne(new LambdaQueryWrapper<T>().eq(field, value));
    }

    /**
     * 根据 field-value ，查询一条记录
     *
     * @param field1 field1
     * @param value1 value1
     * @param field2 field2
     * @param value2 value2
     * @return T
     */
    default T selectOne(String field1, Object value1, String field2, Object value2) {
        return selectOne(new QueryWrapper<T>().eq(field1, value1).eq(field2, value2));
    }

    /**
     * 根据 field-value ，查询一条记录
     *
     * @param field1 field1
     * @param value1 value1
     * @param field2 field2
     * @param value2 value2
     * @return T
     */
    default T selectOne(SFunction<T, ?> field1, Object value1, SFunction<T, ?> field2, Object value2) {
        return selectOne(new LambdaQueryWrapper<T>().eq(field1, value1).eq(field2, value2));
    }

    /**
     * 查询总记录数
     *
     * @return Long
     */
    default Long selectCount() {
        return selectCount(new QueryWrapper<T>());
    }

    /**
     * 根据条件，查询总记录数
     *
     * @param field field
     * @param value value
     * @return Long
     */
    default Long selectCount(String field, Object value) {
        return selectCount(new QueryWrapper<T>().eq(field, value));
    }

    /**
     * 根据条件，查询总记录数
     *
     * @param field field
     * @param value value
     * @return Long
     */
    default Long selectCount(SFunction<T, ?> field, Object value) {
        return selectCount(new LambdaQueryWrapper<T>().eq(field, value));
    }

    /**
     * 查询全部记录
     *
     * @return List
     */
    default List<T> selectList() {
        return selectList(new QueryWrapper<>());
    }

    /**
     * 根据 eq 条件，查询全部记录
     *
     * @param field field
     * @param value value
     * @return List
     */
    default List<T> selectList(String field, Object value) {
        return selectList(new QueryWrapper<T>().eq(field, value));
    }

    /**
     * 根据 eq 条件，查询全部记录
     *
     * @param field field
     * @param value value
     * @return List
     */
    default List<T> selectList(SFunction<T, ?> field, Object value) {
        return selectList(new LambdaQueryWrapper<T>().eq(field, value));
    }

    /**
     * 根据 in 条件，查询全部记录
     *
     * @param field  field
     * @param values values
     * @return List
     */
    default List<T> selectList(String field, Collection<?> values) {
        return selectList(new QueryWrapper<T>().in(field, values));
    }

    /**
     * 根据 in 条件，查询全部记录
     *
     * @param field  field
     * @param values values
     * @return List
     */
    default List<T> selectList(SFunction<T, ?> field, Collection<?> values) {
        return selectList(new LambdaQueryWrapper<T>().in(field, values));
    }

    /**
     * 逐条插入，适合少量数据插入，或者对性能要求不高的场景
     *
     * @param entities entities
     */
    default void insertBatch(Collection<T> entities) {
        entities.forEach(this::insert);
    }

}