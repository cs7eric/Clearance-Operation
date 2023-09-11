package com.cccs7.redis.util;

import com.cccs7.redis.exception.RedisShareLockException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * redis 分布式锁
 *
 * @author cccs7
 * @date 2023/07/29
 */
@Component
public class RedisShareLockUtil {

    private final Long TIME_OUT = 1000L;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 加锁
     *
     * @param lockKey   锁定键
     * @param requestId 请求id
     * @param time      时间
     * @return boolean
     */
    public boolean lock(String lockKey, String requestId, Long time) {

        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0) {
            throw new RedisShareLockException("分布式锁 - 加锁参数异常");
        }

        long currentTime = System.currentTimeMillis();
        long outTime = currentTime + TIME_OUT;
        boolean result = false;
        while (currentTime < outTime) {
            result = redisUtil.setNx(lockKey, requestId, time, TimeUnit.MILLISECONDS);
            if (result) {
                return true;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            currentTime = System.currentTimeMillis();
        }
        return false;
    }

    /**
     * 解锁
     *
     * @param key
     * @param requestId
     * @return boolean
     */
    public boolean unLock(String key, String requestId) {
        if (StringUtils.isBlank(key) || StringUtils.isBlank(requestId)) {
            throw new RedisShareLockException("分布式锁 - 解锁  - 参数异常");
        }

        try {
            String value = redisUtil.get(key);
            if (requestId.equals(value)) {
                redisUtil.del(key);
                return true;
            }
        } catch (Exception e) {

            // 补日志
        }
        return false;

    }


    /**
     * 试一试加锁
     *
     * @param lockKey   加锁key
     * @param requestId 请求id
     * @param time      时间
     * @return boolean
     */
    public boolean tryLock(String lockKey, String requestId, Long time) {

        if (StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0) {
            throw new RedisShareLockException("分布式锁 - 尝试加锁参数错误");
        }
        return redisUtil.setNx(lockKey, requestId, time, TimeUnit.MILLISECONDS);
    }

}
