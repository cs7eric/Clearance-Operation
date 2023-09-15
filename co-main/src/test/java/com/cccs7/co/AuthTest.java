package com.cccs7.co;

import com.cccs7.co.mapper.MenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * <p> 权限测试 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 权限测试
 * @Date 2023/9/15 22:22
 */
@SpringBootTest
public class AuthTest {

    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void testAuth(){

        List<String> list = menuMapper.selectPermsByUserId(1L);
        System.out.println(list);
    }
}
