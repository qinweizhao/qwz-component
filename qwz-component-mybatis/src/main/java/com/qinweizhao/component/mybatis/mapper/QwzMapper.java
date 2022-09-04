package com.qinweizhao.component.mybatis.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.qinweizhao.component.core.request.PageParam;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.util.MyBatisUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import java.util.Collection;
import java.util.List;

import static com.baomidou.mybatisplus.core.enums.SqlMethod.INSERT_ONE;

/**
 * @author qinweizhao
 * @since 2022/4/29
 */
public interface QwzMapper<T> extends BaseMapper<T> {


    Log log = LogFactory.getLog(QwzMapper.class);


    /**
     * 默认批次提交数量
     */
    int DEFAULT_BATCH_SIZE = 1000;

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
        return selectCount(new QueryWrapper<>());
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
     * 批量插入
     *
     * @param entities entities
     * @return boolean
     */
    default boolean insertBatch(Collection<T> entities) {
        return this.insertBatch(entities,DEFAULT_BATCH_SIZE);
    }

    /**
     * 插入（批量）
     *
     * @param entities  实体对象集合
     * @param batchSize 插入批次数量
     * @return boolean
     */
    default boolean insertBatch(Collection<T> entities, int batchSize) {
        String sqlStatement = getSqlStatement(INSERT_ONE);
        return SqlHelper.executeBatch(entities.getClass(), log, entities, batchSize, (sqlSession, entity) -> sqlSession.insert(sqlStatement, entity));

    }

    /**
     * 获取mapperStatementId
     *
     * @param sqlMethod 方法名
     * @return 命名id
     */
    default String getSqlStatement(SqlMethod sqlMethod) {
        return SqlHelper.getSqlStatement(this.getClass(), sqlMethod);
    }

}