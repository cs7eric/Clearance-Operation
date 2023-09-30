package com.cccs7.co.service.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.cccs7.co.service.CodeService;
import com.cccs7.co.service.MailService;
import com.cccs7.co.tool.CodeUtil;
import com.cccs7.mail.config.MailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Scanner;

/**
 * <p> 邮件服务实现类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 邮件服务实现类
 * @Date 2023/9/30 11:48
 */
@Service
public class MailServiceImpl implements MailService {

    /**
     * 邮件帐户名称
     */


    @Autowired
    private JavaMailSenderImpl mailSender;

    @Autowired
    private CodeService codeService;

    /**
     * 发送邮件消息
     *
     * @param address 地址
     */
    @Override
    public void sendMailMessage(String address) {

        // 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        //下面填写密钥
        IClientProfile profile = DefaultProfile.getProfile(MailConfig.REGION_ID, MailConfig.ACCESS_KEY_ID, MailConfig.SECRET);
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        //使用https加密连接
        request.setProtocol(ProtocolType.HTTPS);
        try {
            //request.setVersion("2017-06-22");// 如果是除杭州region外的其它region（如新加坡region）,必须指定为2017-06-22
            request.setAccountName(MailConfig.MAIL_ACCOUNT_NAME);
            request.setFromAlias(MailConfig.FROM_ALIAS);
            request.setAddressType(1);
            //可以不需要
            //request.setTagName("控制台创建的标签");
            //是否需要回信功能
            request.setReplyToAddress(true);
            request.setToAddress(address);
            //可以给多个收件人发送邮件，收件人之间用逗号分开，批量发信建议使用BatchSendMailRequest方式
            //request.setToAddress("邮箱1,邮箱2");
            request.setSubject(MailConfig.EMAIL_TITLE);

            // 邮件模板
            String htmlBody = setTemplate();

            // 生成邮箱验证码
            String code = CodeUtil.generateCode();

            // 缓存验证码到 redis
            codeService.cacheCode(code, address);

            htmlBody = htmlBody.replace("[address]", address).replace("[code]", code);
            request.setHtmlBody(htmlBody);
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置邮箱验证码模板
     *
     * @return {@link String}
     */
    public String setTemplate() {
        ClassPathResource mailTemplate = new ClassPathResource(MailConfig.EMAIL_TEMPLATE);
        System.out.println(mailTemplate);
        Scanner scanner = null;
        try {
            scanner = new Scanner(mailTemplate.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String htmlBody = "";
        while (scanner.hasNextLine()) {
            htmlBody += scanner.nextLine() + System.getProperty("line.separator");
        }
        return htmlBody;
    }
}
