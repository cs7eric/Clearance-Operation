package com.cccs7.redis.exception;


/**
 * redis 分布式锁异常
 *
 * @author cccs7
 * @date 2023/07/29
 */
public class RedisShareLockException extends RuntimeException {

    public RedisShareLockException(String message) {
        super(message);
    }
}
