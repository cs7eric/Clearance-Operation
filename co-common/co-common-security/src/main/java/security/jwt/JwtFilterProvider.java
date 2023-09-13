package security.jwt;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * <p> JwtFilterProvider </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description JwtFilterProvider
 * @Date 2023/8/7 16:16
 */
public interface JwtFilterProvider {


    /**
     * 获取JWT身份验证令牌过滤器
     *
     * @return {@link OncePerRequestFilter}
     */
    OncePerRequestFilter getJwtAuthenticationTokenFilter();
}
