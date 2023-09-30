package com.cccs7.co.tool;

import java.security.SecureRandom;

/**
 * <p> 验证码工具类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 验证码工具类
 * @Date 2023/9/30 18:09
 */
public class CodeUtil {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int CODE_LENGTH = 6;
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * 生成代码
     *
     * @return {@link String}
     */
    public static String generateCode() {
        StringBuilder code = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            code.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return code.toString();
    }
}
