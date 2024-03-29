package com.qinweizhao.component.mybatis.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * @author qinweizhao
 * @since 2022/4/29
 */
public class QwzQueryWrapper<T> extends QueryWrapper<T> {

    public QwzQueryWrapper<T> likeIfPresent(String column, String val) {
        if (StringUtils.hasText(val)) {
            return (QwzQueryWrapper<T>) super.like(column, val);
        }
        return this;
    }

    public QwzQueryWrapper<T> inIfPresent(String column, Collection<?> values) {
        if (!CollectionUtils.isEmpty(values)) {
            return (QwzQueryWrapper<T>) super.in(column, values);
        }
        return this;
    }

    public QwzQueryWrapper<T> inIfPresent(String column, Object... values) {
        if (!ArrayUtils.isEmpty(values)) {
            return (QwzQueryWrapper<T>) super.in(column, values);
        }
        return this;
    }

    public QwzQueryWrapper<T> eqIfPresent(String column, Object val) {
        if (val != null) {
            return (QwzQueryWrapper<T>) super.eq(column, val);
        }
        return this;
    }

    public QwzQueryWrapper<T> neIfPresent(String column, Object val) {
        if (val != null) {
            return (QwzQueryWrapper<T>) super.ne(column, val);
        }
        return this;
    }

    public QwzQueryWrapper<T> gtIfPresent(String column, Object val) {
        if (val != null) {
            return (QwzQueryWrapper<T>) super.gt(column, val);
        }
        return this;
    }

    public QwzQueryWrapper<T> geIfPresent(String column, Object val) {
        if (val != null) {
            return (QwzQueryWrapper<T>) super.ge(column, val);
        }
        return this;
    }

    public QwzQueryWrapper<T> ltIfPresent(String column, Object val) {
        if (val != null) {
            return (QwzQueryWrapper<T>) super.lt(column, val);
        }
        return this;
    }

    public QwzQueryWrapper<T> leIfPresent(String column, Object val) {
        if (val != null) {
            return (QwzQueryWrapper<T>) super.le(column, val);
        }
        return this;
    }

    public QwzQueryWrapper<T> betweenIfPresent(String column, Object val1, Object val2) {
        if (val1 != null && val2 != null) {
            return (QwzQueryWrapper<T>) super.between(column, val1, val2);
        }
        if (val1 != null) {
            return (QwzQueryWrapper<T>) ge(column, val1);
        }
        if (val2 != null) {
            return (QwzQueryWrapper<T>) le(column, val2);
        }
        return this;
    }

    // ========== 重写父类方法，方便链式调用 ==========

    @Override
    public QwzQueryWrapper<T> eq(boolean condition, String column, Object val) {
        super.eq(condition, column, val);
        return this;
    }

    @Override
    public QwzQueryWrapper<T> eq(String column, Object val) {
        super.eq(column, val);
        return this;
    }

    @Override
    public QwzQueryWrapper<T> orderByDesc(String column) {
        super.orderByDesc(true, column);
        return this;
    }

    @Override
    public QwzQueryWrapper<T> last(String lastSql) {
        super.last(lastSql);
        return this;
    }

    @Override
    public QwzQueryWrapper<T> in(String column, Collection<?> coll) {
        super.in(column, coll);
        return this;
    }

}
