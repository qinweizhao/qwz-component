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
     * ????????????
     */
    private final static String ENV_PROD = "prod";


    /**
     * ????????????
     */
    @Value("${spring.profiles.active:prod}")
    private String profile;


    /**
     * Controller?????????????????????
     *
     * @param e ??????
     * @return ????????????
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
    public R<?> handleServletException(Exception e) {
        String errorMessage;
        if (e instanceof BindException) {
            BindingResult bindingResult = ((BindException) e).getBindingResult();
            errorMessage = bindingResult.getErrorCount() > 0 ? bindingResult.getAllErrors().get(0).getDefaultMessage()
                    : "????????????????????????!";
            log.error("????????????-??????????????????,ex = {}", errorMessage);
        } else {
            log.error("???????????? ex={}", e.getMessage());
            errorMessage = ENV_PROD.equals(profile) ? SystemResultCodeEnum.BAD_REQUEST.getMessage() : e.getMessage();

        }
        return R.failure(SystemResultCodeEnum.BAD_REQUEST.getCode(), errorMessage);
    }

    /**
     * ????????????
     *
     * @param e ??????
     * @return ????????????
     */
    @ExceptionHandler(value = BizException.class)
    public R<?> handleBusinessException(BizException e) {
        log.error("?????????????????? ex={}", e.getMessage());
        return R.failure(e.getCode(), e.getMessage());
    }


    /**
     * ???????????????
     *
     * @param e ??????
     * @return ????????????
     */
    @ExceptionHandler(value = BaseException.class)
    public R<?> handleBaseException(BaseException e) {
        log.error("????????????????????? ex={}", e.getMessage());
        return R.failure(e.getCode(), e.getMessage());
    }


    /**
     * ???????????????
     *
     * @param e the e
     * @return R
     */
    @ExceptionHandler(Exception.class)
    public R<String> handleException(Exception e) {
        log.error("?????????????????? ex={}", e.getMessage(), e);
        // ??????????????????, ????????????????????????????????????????????????, ???????????????????????????.
        String errorMessage = ENV_PROD.equals(profile) ? SystemResultCodeEnum.SERVER_ERROR.getMessage() : e.getLocalizedMessage();
        return R.failure(SystemResultCodeEnum.SERVER_ERROR.getCode(), errorMessage);
    }
}
