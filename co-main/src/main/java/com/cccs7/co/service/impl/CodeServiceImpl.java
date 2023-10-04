package com.cccs7.co.service.impl;

import com.cccs7.co.service.CodeService;
import com.cccs7.redis.util.RedisCache;
import org.apache.commons.lang.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p> 验证码服务接口实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 验证码服务接口实现类
 * @Date 2023/9/30 18:32
 */
@Service
public class CodeServiceImpl implements CodeService {

    public static final String AUTH_CODE_CACHE = "auth:";

    @Autowired
    private RedisCache redisCache;

    /**
     * 缓存验证码
     *
     * @param code    验证码
     * @param address 邮箱地址
     */
    @Override
    public void cacheCode(String code, String address) {

        String codeKey = AUTH_CODE_CACHE + address;
        String expiredKey = redisCache.getCacheObject(codeKey);
        if (StringUtils.isNotBlank(expiredKey)) {
            redisCache.deleteObject(codeKey);
        }
        redisCache.setCacheObject(codeKey, code, 5*60, TimeUnit.SECONDS);
    }
}
