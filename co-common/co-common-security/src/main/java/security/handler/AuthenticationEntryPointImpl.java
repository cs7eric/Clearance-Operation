package security.handler;

import com.alibaba.fastjson.JSON;
import com.cccs7.web.bean.Result;
import com.cccs7.web.util.WebUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p> 认证失败处理器 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 认证失败处理器
 * @Date 2023/8/7 23:12
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        Result<Object> result = Result.fail(HttpServletResponse.SC_UNAUTHORIZED, "认证失败");
        // 您还可以根据需要设置其他属性
        String json = JSON.toJSONString(result);

        WebUtils.renderString(response, json);
    }
}
