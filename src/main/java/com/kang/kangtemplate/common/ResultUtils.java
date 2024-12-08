package com.kang.kangtemplate.common;

/**
 * @description: 通用响应工具类
 * @author: liukang
 * @date: 2024/12/08 14:39:53
 */
public class ResultUtils {

    /**
     * 成功响应
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(ErrorCodeEnum.SUCCESS.getCode(), ErrorCodeEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 成功响应（自定义消息）
     */
    public static <T> BaseResponse<T> success(T data, String message) {
        return new BaseResponse<>(ErrorCodeEnum.SUCCESS.getCode(), message, data);
    }

    /**
     * 错误响应（基于错误枚举）
     */
    public static <T> BaseResponse<T> error(ErrorCodeEnum errorCodeEnum) {
        return new BaseResponse<>(errorCodeEnum.getCode(), errorCodeEnum.getMessage(), null);
    }

    /**
     * 错误响应（基于错误枚举和自定义消息）
     */
    public static <T> BaseResponse<T> error(ErrorCodeEnum errorCodeEnum, String message) {
        return new BaseResponse<>(errorCodeEnum.getCode(), message, null);
    }

    /**
     * 自定义错误响应
     */
    public static <T> BaseResponse<T> error(int code, String message) {
        return new BaseResponse<>(code, message, null);
    }
}