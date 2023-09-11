package com.cccs7.redis.util;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * <p> 本地缓存工具类 </p>
 *
 * @Author cccs7/cs7eric - csq020611@gmail.com
 * @Description 本地缓存工具类
 * @Date 2023/8/8 14:09
 */
@Component
public class GuavaCacheUtil<K, V> {

    @Value("${guava.cache.switch}")
    public Boolean switchCache;

    private Cache<String, String> localCache =
            CacheBuilder.newBuilder()
                    .maximumSize(5000)
                    .expireAfterWrite(3, TimeUnit.SECONDS)
                    .build();

    public Map<K, V> getResult(List<K> idList, String cacheKeyPrefix,
                               String cacheSuffix, Class<V> clazz,
                               Function<List<K>, Map<K, V>> function) {

        if (CollectionUtils.isEmpty(idList)) {
            return Collections.emptyMap();
        }

        Map<K, V> resultMap = new HashMap<>();
        if (!switchCache) {
            resultMap = function.apply(idList);
            return resultMap;
        }

        List<K> noCacheList = new LinkedList<>();
        for (K id : idList) {
            String cacheKey = cacheKeyPrefix + "_" + id + "_" + cacheSuffix;
            String content = localCache.getIfPresent(cacheKey);
            if (StringUtils.isNotBlank(content)) {
                V v = JSON.parseObject(content, clazz);
                resultMap.put(id, v);
            } else {
                noCacheList.add(id);
            }
        }
        if (CollectionUtils.isEmpty(noCacheList)) {
            return resultMap;
        }

        Map<K, V> noCacheResultMap = function.apply(noCacheList);
        if (noCacheResultMap == null || noCacheResultMap.isEmpty()) {
            return resultMap;
        }
        for (Map.Entry<K, V> entry :
                noCacheResultMap.entrySet()) {
            K id = entry.getKey();
            V result = entry.getValue();
            resultMap.put(id, result);
            String cacheKey = cacheKeyPrefix + "_" + id + "_" + cacheSuffix;
            localCache.put(cacheKey, JSON.toJSONString(result));
        }
        return resultMap;
    }
}


