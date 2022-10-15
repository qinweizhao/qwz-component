package com.qinweizhao.component.mybatis.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author qinweizhao
 * @since 2022/4/29
 */
public interface QwzService<T> {


    /**
     * 默认批次提交数量
     */
    int DEFAULT_BATCH_SIZE = 1000;


    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     * @return boolean
     */
    default boolean removeById(Serializable id) {
        return SqlHelper.retBool(getBaseMapper().deleteById(id));
    }

    /**
     * 根据 ID 删除（批量）
     *
     * @param list 主键ID或实体列表(主键ID类型必须与实体类型字段保持一致)
     * @return 删除结果
     */
    @Transactional(rollbackFor = Exception.class)
    default boolean removeBatchByIds(Collection<?> list) {
        return removeBatchByIds(list, DEFAULT_BATCH_SIZE);
    }

    /**
     * 根据 ID 删除（批量，可指定大小）
     *
     * @param list      主键ID或实体列表
     * @param batchSize 批次大小
     * @return 删除结果
     */
    default boolean removeBatchByIds(Collection<?> list, int batchSize) {
        throw new UnsupportedOperationException("不支持的方法!");
    }

    /**
     * 根据 ID 更新
     *
     * @param entity 实体对象
     * @return boolean
     */
    default boolean updateById(T entity) {
        return SqlHelper.retBool(getBaseMapper().updateById(entity));
    }

    /**
     * 根据 ID 更新（批量）
     *
     * @param entityList 实体对象集合
     * @return boolean
     */
    @Transactional(rollbackFor = Exception.class)
    default boolean updateBatchById(Collection<T> entityList) {
        return updateBatchById(entityList, DEFAULT_BATCH_SIZE);
    }

    /**
     * 根据 ID 更新（批量，可指定大小）
     *
     * @param entityList 实体对象集合
     * @param batchSize  更新批次数量
     * @return boolean
     */
    boolean updateBatchById(Collection<T> entityList, int batchSize);

    /**
     * 获取对应 entity 的 BaseMapper
     *
     * @return BaseMapper
     */
    BaseMapper<T> getBaseMapper();

    /**
     * 获取 entity 的 class
     *
     * @return {@link Class<T>}
     */
    Class<T> getEntityClass();
}
