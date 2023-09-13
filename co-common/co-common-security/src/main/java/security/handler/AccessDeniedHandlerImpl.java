package security.handler;

import com.alibaba.fastjson.JSON;
import com.cccs7.web.bean.Result;
import com.cccs7.web.util.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p> 授权失败处理器 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 授权失败处理器
 * @Date 2023/8/7 23:03
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {


    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException {

        // 创建自定义的 Result 响应对象
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        Result<Object> result = Result.fail(HttpServletResponse.SC_FORBIDDEN, "权限不足");
        // 您还可以根据需要设置其他属性
        String json = JSON.toJSONString(result);

        WebUtils.renderString(response, json);
    }
}
