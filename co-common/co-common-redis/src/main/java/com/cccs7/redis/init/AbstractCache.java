package com.cccs7.redis.init;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractCache {

    public void initCache() {
    }

    public <T> T getCache(String key) {
        return null;
    }

    public void clearCache() {
    }

    public void reloadCache() {
        clearCache();
        initCache();
    }
}
