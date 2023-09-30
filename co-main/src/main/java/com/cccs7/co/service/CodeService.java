package com.cccs7.co.service;

/**
 * <p> 验证码服务接口 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 验证码服务接口
 * @Date 2023/9/30 18:31
 */
public interface CodeService {

    /**
     * 缓存验证码到
     *
     * @param code    验证码
     * @param address  邮箱地址
     */
    void cacheCode(String code, String address);
}
