package com.qinweizhao.component.exception.util;

import com.qinweizhao.component.exception.BizException;

import java.util.Collection;
import java.util.Map;

/**
 * 断言工具类
 *
 * @author qinweizhao
 * @since 2022/4/12
 */
public abstract class Assert {

    /**
     * 断言一个布尔表达式，抛出 {@code BizException}
     *
     * @param expression expression
     * @param errorCode  errorCode
     * @param errMessage errMessage
     */
    public static void isTrue(boolean expression, String errorCode, String errMessage) {
        if (!expression) {
            throw new BizException(errorCode, errMessage);
        }
    }

    /**
     * 断言一个布尔表达式，如果表达式为真，则抛出 {@code BizException}
     * <p>
     * 例如
     *
     * <pre class="code">Assert.isFalse(i == 0, errorCode.B_ORDER_illegalNumber, "The order number can not be zero");</pre>
     * <p>
     *
     * @param expression expression
     * @param errorCode  errorCode
     * @param errMessage errMessage
     */
    public static void isFalse(boolean expression, String errorCode, String errMessage) {
        if (expression) {
            throw new BizException(errorCode, errMessage);
        }
    }

    public static void isTrue(boolean expression, String errMessage) {
        if (!expression) {
            throw new BizException(errMessage);
        }
    }

    public static void isFalse(boolean expression, String errMessage) {
        if (expression) {
            throw new BizException(errMessage);
        }
    }

    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] Must be true");
    }

    public static void isFalse(boolean expression) {
        isFalse(expression, "[Assertion failed] Must be false");
    }

    public static void notNull(Object object, String errorCode, String errMessage) {
        if (object == null) {
            throw new BizException(errorCode, errMessage);
        }
    }

    public static void notNull(Object object, String errMessage) {
        if (object == null) {
            throw new BizException(errMessage);
        }
    }

    public static void notNull(Object object) {
        notNull(object, "[Assertion failed] Must not null");
    }

    public static void notEmpty(Collection<?> collection, String errorCode, String errMessage) {
        if (collection == null || collection.isEmpty()) {
            throw new BizException(errorCode, errMessage);
        }
    }

    public static void notEmpty(Collection<?> collection, String errMessage) {
        if (collection == null || collection.isEmpty()) {
            throw new BizException(errMessage);
        }
    }

    public static void notEmpty(Collection<?> collection) {
        notEmpty(collection, "[Assertion failed] Collection must not be empty: it must contain at least 1 element");
    }

    public static void notEmpty(Map<?, ?> map, String errorCode, String errMessage) {
        if (map == null || map.isEmpty()) {
            throw new BizException(errorCode, errMessage);
        }
    }

    public static void notEmpty(Map<?, ?> map, String errMessage) {
        if (map == null || map.isEmpty()) {
            throw new BizException(errMessage);
        }
    }

    public static void notEmpty(Map<?, ?> map) {
        notEmpty(map, "[Assertion failed] Map must not be empty: it must contain at least one entry");
    }

}
