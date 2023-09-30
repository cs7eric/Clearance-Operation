package com.cccs7.co.test;

import com.cccs7.co.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p> 邮件服务测试类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 邮件服务测试类
 * @Date 2023/9/30 11:35
 */
@SpringBootTest
public class MailTest {


    @Autowired
    private MailService mailService;

    @Test
    public void sendMessage() {

        mailService.sendMailMessage();
    }
}
