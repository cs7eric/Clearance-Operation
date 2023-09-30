package com.cccs7.mail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.IOException;
import java.util.Scanner;

/**
 * <p> 阿里云邮件服务配置类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 阿里云邮件服务配置类
 * @Date 2023/9/30 15:45
 */
@Configuration
public class MailConfig {

    /**
     * 邮件帐户名称
     */
    public static String MAIL_ACCOUNT_NAME;
    /**
     * 区域id
     */
    public static String REGION_ID;
    /**
     * AccessKey ID
     */
    public static String ACCESS_KEY_ID;
    /**
     * 私钥
     */
    public static String SECRET;
    /**
     * 发送别名
     */
    public static String FROM_ALIAS;

    /**
     * 电子邮件模板
     */
    public static final String EMAIL_TEMPLATE = "static/mail_register_template.html";

    public static final String EMAIL_TITLE = "[co-肃清行动: 邮箱验证]";

    @Value("${co.email.mail_account_name}")
    public void setMailAccountName(String mailAccountName) {
        MAIL_ACCOUNT_NAME = mailAccountName;
    }

    @Value("${co.email.region_id}")
    public void setRegionId(String regionId) {
        REGION_ID = regionId;
    }

    @Value("${co.email.from_alias}")
    public void setFromAlias(String fromAlias) {
        FROM_ALIAS = fromAlias;
    }

    static {
        ClassPathResource smsKey = new ClassPathResource("privatekey/SMSKey.txt");
        try (Scanner scanner = new Scanner(smsKey.getInputStream())) {
            if (scanner.hasNextLine()) {
                ACCESS_KEY_ID = scanner.nextLine();
            }
            if (scanner.hasNextLine()) {
                SECRET = scanner.nextLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read SMSKey.txt", e);
        }
    }

    @Bean
    public JavaMailSenderImpl javaMailSender() {
        return new JavaMailSenderImpl();
    }
}
