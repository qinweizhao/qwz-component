package com.qinweizhao.component.mybatis.toolkit;


import com.qinweizhao.component.mybatis.query.QwzLambdaQueryWrapper;

/**
 * @author qinweizhao
 */
public final class WrappersX {

    private WrappersX() {
    }

    /**
     * 获取 LambdaQueryWrapperX&lt;T&gt;
     *
     * @param <T> 实体类泛型
     * @return LambdaQueryWrapperX&lt;T&gt;
     */
    public static <T> QwzLambdaQueryWrapper<T> lambdaQueryX() {
        return new QwzLambdaQueryWrapper<>();
    }

    /**
     * 获取 LambdaQueryWrapperX&lt;T&gt;
     *
     * @param entity 实体类
     * @param <T>    实体类泛型
     * @return LambdaQueryWrapperX&lt;T&gt;
     */
    public static <T> QwzLambdaQueryWrapper<T> lambdaQueryX(T entity) {
        return new QwzLambdaQueryWrapper<>(entity);
    }

    /**
     * 获取 LambdaQueryWrapperX&lt;T&gt;
     *
     * @param entityClass 实体类class
     * @param <T>         实体类泛型
     * @return LambdaQueryWrapperX&lt;T&gt;
     * @since 3.3.1
     */
    public static <T> QwzLambdaQueryWrapper<T> lambdaQueryX(Class<T> entityClass) {
        return new QwzLambdaQueryWrapper<>(entityClass);
    }

}
