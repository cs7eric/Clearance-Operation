package com.cccs7.co.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import security.jwt.JwtFilterProvider;

/**
 * <p> filterProvider  - jwt </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description filterProvider  - jwt
 * @Date 2023/8/7 16:20
 */
@Component
public class JwtFilterProviderImpl implements JwtFilterProvider {


    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    public JwtFilterProviderImpl(JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter) {
        this.jwtAuthenticationTokenFilter = jwtAuthenticationTokenFilter;
    }

    @Override
    public OncePerRequestFilter getJwtAuthenticationTokenFilter() {
        return jwtAuthenticationTokenFilter;
    }
}
