package com.cccs7.web.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 结果
 * 统一结果返回类
 * 该类表示API调用的标准化响应格式。
 *
 * @Author cccs7
 * @Date 2023/09/15
 */
@Data
public class Result<T> implements Serializable {

    private boolean success; // 表示操作是否成功
    private Integer code; // 响应关联的结果代码
    private String message; // 提供附加信息的结果消息
    private T data; // 响应关联的数据载荷


    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Result(boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 创建一个成功的结果响应，不包含任何数据。
     *
     * @return Result对象，表示成功的结果响应
     */
    public static <T> Result<T> ok() {
        return new Result<>(true, ResultCode.SUCCESS_CODE, ResultMessage.SUCCESS_MESSAGE, null);
    }

    /**
     * 创建一个成功的结果响应，包含指定的数据。
     *
     * @param data 响应中包含的数据
     * @return Result对象，表示成功的结果响应
     */
    public static <T> Result<T> ok(T data) {
        return new Result<>(true, ResultCode.SUCCESS_CODE, ResultMessage.SUCCESS_MESSAGE, data);
    }

    /**
     * 创建一个成功的结果响应，包含指定的结果代码和结果消息，但不包含数据。
     *
     * @param resultCode    结果代码
     * @param resultMessage 结果消息
     * @return Result对象，表示成功的结果响应
     */
    public static <T> Result<T> ok(Integer resultCode, String resultMessage) {
        return new Result<>(true, resultCode, resultMessage, null);
    }

    /**
     * 创建一个成功的结果响应，包含指定的结果代码、结果消息和数据。
     *
     * @param resultCode    结果代码
     * @param resultMessage 结果消息
     * @param data          响应中包含的数据
     * @return Result对象，表示成功的结果响应
     */
    public static <T> Result<T> ok(Integer resultCode, String resultMessage, T data) {
        return new Result<>(true, resultCode, resultMessage, data);
    }

    /**
     * 创建一个失败的结果响应，不包含任何数据。
     *
     * @return Result对象，表示失败的结果响应
     */
    public static <T> Result<T> fail() {
        return new Result<>(false, ResultCode.ERROR_CODE, ResultMessage.ERROR_MESSAGE, null);
    }

    /**
     * 创建一个失败的结果响应，包含指定的数据。
     *
     * @param data 响应中包含的数据
     * @return Result对象，表示失败的结果响应
     */
    public static <T> Result<T> fail(T data) {
        return new Result<>(false, ResultCode.ERROR_CODE, ResultMessage.ERROR_MESSAGE, data);
    }

    /**
     * 创建一个失败的结果响应，包含指定的结果代码和结果消息，但不包含数据。
     *
     * @param resultCode    结果代码
     * @param resultMessage 结果消息
     * @return Result对象，表示失败的结果响应
     */
    public static <T> Result<T> fail(Integer resultCode, String resultMessage) {
        return new Result<>(false, resultCode, resultMessage, null);
    }

    /**
     * 创建一个失败的结果响应，包含指定的结果代码、结果消息和数据。
     *
     * @param resultCode    结果代码
     * @param resultMessage 结果消息
     * @param data          响应中包含的数据
     * @return Result对象，表示失败的结果响应
     */
    public static <T> Result<T> fail(Integer resultCode, String resultMessage, T data) {
        return new Result<>(false, resultCode, resultMessage, data);
    }
}