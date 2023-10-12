package com.cccs7.co.encrypt;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p> 加密工具类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 加密工具类
 * @Date 2023/10/12 10:22
 */
@Component
public class EncryptUtil {

    @Autowired
    private StringEncryptor encryptor;

    /**
     * 加密
     *
     * @param content 内容内容
     * @return {@link String} 加密结果
     */
    public String encrypt(String content) {
        System.out.println("请求加密,加密内容：" + content);
        try {
            return encryptor.encrypt(content);
        } catch (Exception e) {
            System.err.println("请求加密异常:" + e);
            return "加密异常";
        }
    }
}
