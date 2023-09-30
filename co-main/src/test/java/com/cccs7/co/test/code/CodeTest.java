package com.cccs7.co.test.code;

import com.cccs7.co.service.CodeService;
import com.cccs7.co.tool.CodeUtil;
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

    @Test
    public void generateCodeTest () {
        System.out.println(CodeUtil.generateCode());
    }

    @Test
    public void cacheCodeTest() {
        codeService.cacheCode("7U9oK2", "csq020611@icloud.com");
    }
}


