package com.cccs7.co.service;

import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;

/**
 * <p> 邮件服务接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 邮件服务接口
 * @Date 2023/9/30 11:48
 */
public interface MailService {

    /**
     * 发送邮件消息
     *
     * @param address 地址
     */
    void sendMailMessage(@NotNull String address);
}
