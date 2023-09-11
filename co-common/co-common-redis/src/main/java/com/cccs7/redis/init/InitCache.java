package com.cccs7.redis.init;

import com.cccs7.redis.util.SpringContextUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class InitCache implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
        Map<String, AbstractCache> beanMap = applicationContext.getBeansOfType(AbstractCache.class);
        if (beanMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, AbstractCache> entry : beanMap.entrySet()) {
            AbstractCache abstractCache = (AbstractCache) SpringContextUtil.getBean(entry.getValue().getClass());
            abstractCache.initCache();
        }
    }
}
