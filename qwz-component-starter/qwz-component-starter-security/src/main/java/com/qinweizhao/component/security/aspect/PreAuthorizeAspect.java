package com.qinweizhao.component.security.aspect;

import com.qinweizhao.component.security.annotation.RequiresLogin;
import com.qinweizhao.component.security.annotation.RequiresPermissions;
import com.qinweizhao.component.security.annotation.RequiresRoles;
import com.qinweizhao.component.security.auth.AuthUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 鉴权
 *
 * @author qinweizhao
 */
@Aspect
@Component
public class PreAuthorizeAspect {

    /**
     * 定义AOP签名 (切入所有使用鉴权注解的方法)
     */
    public static final String POINTCUT_SIGN = " @annotation(com.qinweizhao.component.security.annotation.RequiresLogin) || "
            + "@annotation(com.qinweizhao.component.security.annotation.RequiresPermissions) || "
            + "@annotation(com.qinweizhao.component.security.annotation.RequiresRoles)";

    /**
     * 构建
     */
    public PreAuthorizeAspect() {

    }

    /**
     * 声明AOP签名
     */
    @Pointcut(POINTCUT_SIGN)
    public void pointcut() {
    }

    /**
     * 环绕切入
     *
     * @param joinPoint 切面对象
     * @return 底层方法执行后的返回值
     * @throws Throwable 底层方法抛出的异常
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 注解鉴权
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        checkMethodAnnotation(signature.getMethod());
        // 执行原有逻辑
        return joinPoint.proceed();
    }

    /**
     * 对一个Method对象进行注解检查
     */
    public void checkMethodAnnotation(Method method) {
        // 校验 @RequiresLogin 注解
        RequiresLogin requiresLogin = method.getAnnotation(RequiresLogin.class);
        if (requiresLogin != null) {
            this.doCheckLogin();
        }

        // 校验 @RequiresRoles 注解
        RequiresRoles requiresRoles = method.getAnnotation(RequiresRoles.class);
        if (requiresRoles != null) {
            this.doCheckRole(requiresRoles);
        }

        // 校验 @RequiresPermissions 注解
        RequiresPermissions requiresPermissions = method.getAnnotation(RequiresPermissions.class);
        if (requiresPermissions != null) {
            this.doCheckPermissions(requiresPermissions);
        }
    }


    /**
     * 校验权限
     * @param requiresPermissions requiresPermissions
     */
    private void doCheckPermissions(RequiresPermissions requiresPermissions) {


    }


    /**
     * 校验角色
     * @param requiresRoles requiresRoles
     */
    private void doCheckRole(RequiresRoles requiresRoles) {

    }

    /**
     * 校验登陆
     */
    private void doCheckLogin() {

    }
}
