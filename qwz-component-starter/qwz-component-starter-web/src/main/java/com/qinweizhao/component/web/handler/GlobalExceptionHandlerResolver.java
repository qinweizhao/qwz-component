package com.qinweizhao.component.web.handler;

import com.qinweizhao.component.core.exception.BaseException;
import com.qinweizhao.component.core.exception.BizException;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.core.response.SystemResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.xml.bind.ValidationException;


/**
 * @author qinweizhao
 * @since 2022/4/13
 */
@Component
@RestControllerAdvice
@ConditionalOnWebApplication
@ConditionalOnMissingBean(GlobalExceptionHandlerResolver.class)
public class GlobalExceptionHandlerResolver {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerResolver.class);

    /**
     * 生产环境
     */
    private final static String ENV_PROD = "prod";


    /**
     * 当前环境
     */
    @Value("${spring.profiles.active:prod}")
    private String profile;


    /**
     * Controller上一层相关异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            BindException.class,
            MethodArgumentNotValidException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class,
            ValidationException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public R<?> handleServletException(Exception e) {
        String errorMessage;
        if (e instanceof BindException) {
            BindingResult bindingResult = ((BindException) e).getBindingResult();
            errorMessage = bindingResult.getErrorCount() > 0 ? bindingResult.getAllErrors().get(0).getDefaultMessage()
                    : "未获取到错误信息!";
            log.error("请求异常-参数绑定异常,ex = {}", errorMessage);
        } else {
            log.error("请求异常 ex={}", e.getMessage());
            errorMessage = ENV_PROD.equals(profile) ? SystemResultCodeEnum.BAD_REQUEST.getMessage() : e.getMessage();

        }
        return R.failure(SystemResultCodeEnum.BAD_REQUEST.getCode(), errorMessage);
    }

    /**
     * 业务异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BizException.class)
    public R<?> handleBusinessException(BizException e) {
        log.error("业务异常信息 ex={}", e.getMessage());
        return R.failure(e.getCode(), e.getMessage());
    }


    /**
     * 自定义异常
     *
     * @param e 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseStatus(HttpStatus.OK)
    public R<?> handleBaseException(BaseException e) {
        log.error("自定义异常信息 ex={}", e.getMessage());
        return R.failure(e.getCode(), e.getMessage());
    }


    /**
     * 未定义异常
     *
     * @param e the e
     * @return R
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R<String> handleException(Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        // 当为生产环境, 不适合把具体的异常信息展示给用户, 比如数据库异常信息.
        String errorMessage = ENV_PROD.equals(profile) ? SystemResultCodeEnum.SERVER_ERROR.getMessage() : e.getLocalizedMessage();
        return R.failure(SystemResultCodeEnum.SERVER_ERROR.getCode(), errorMessage);
    }
}
