package com.cccs7.web.common;

import com.cccs7.web.bean.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理器
 *
 * @author cccs7
 * @date 2023/08/07
 */
public interface ExceptionAdaptController {

    /**
     * 处理程序运行时异常
     *
     * @param runtimeException 运行时异常
     * @return {@link Result}
     */
    @ExceptionHandler({RuntimeException.class})
    Result handlerRuntimeException(RuntimeException runtimeException);

    /**
     * 异常处理程序
     *
     * @param exception 异常
     * @return {@link Result}
     */
    @ExceptionHandler({Exception.class})
    Result handlerException(Exception exception);
}
