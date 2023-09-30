package com.cccs7.co.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * <p> 邮箱测试类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 邮箱测试类
 * @Date 2023/9/30 11:08
 */

public class MailTest {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    private void sendMessage() {
        String emailServiceCode = "E34DF9";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("注册验证码");
        message.setText("注册验证码是" + emailServiceCode);
        message.setFrom("csq020611@gmail.com");
        mailSender.send(message);
    }
}
