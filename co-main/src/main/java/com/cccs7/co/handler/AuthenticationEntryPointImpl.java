package com.cccs7.co.handler;

import com.alibaba.fastjson.JSON;
import com.cccs7.web.bean.Result;
import com.cccs7.web.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p> 认证异常处理 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 认证异常处理
 * @Date 2023/9/15 22:59
 */
@Component
public class AuthenticationEntryPointImpl  implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Result<Object> result = new Result<>(HttpStatus.FORBIDDEN.value(), "认证失败，请重新登录");
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response, json);
    }
}
