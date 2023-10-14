package com.cccs7.co.test.code;

import com.cccs7.co.service.CodeService;
import com.cccs7.co.tool.CodeUtil;
import com.cccs7.redis.util.RedisCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * <p> 验证码测试类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 验证码测试类
 * @Date 2023/9/30 17:53
 */
@SpringBootTest
public class CodeTest {

    @Autowired
    private CodeService codeService;

    @Autowired
    private RedisCache redisCache;

    @Test
    public void generateCodeTest () {
        System.out.println(CodeUtil.generateCode());
    }

    @Test
    public void cacheCodeTest() {
        codeService.cacheCode("111111", "byxl8112@icloud.com");
    }

    @Test
    public void getCache() {
        codeService.cacheCode("i8K0II","byxl8112@gmail.com");
    }

    @Test
    public void setCache() {

        String email = "cccs7@icloud.com";
        String key = "auth:" + email;
        String code = "Cccs71";
        redisCache.setCacheObject(key, code);
    }
}


