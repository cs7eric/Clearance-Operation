package com.cccs7.web.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 *  异常类
 * @author 16628
 * @date 2023/10/11
 */
@NoArgsConstructor  //无参构造
@AllArgsConstructor  //满参构造
public class BaseException extends RuntimeException {

    /**
     * 异常信息体
     */
    private String msg;
}
