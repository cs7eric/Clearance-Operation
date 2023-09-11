package com.cccs7.redis.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * SpringContext工具类
 *
 * @author cccs7
 * @date 2023/07/29
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return SpringContextUtil.applicationContext;
    }

    public static Object getBean(Class type) {
        return SpringContextUtil.applicationContext.getBean(type);
    }
}
