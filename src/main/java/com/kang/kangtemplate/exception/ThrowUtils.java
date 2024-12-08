package com.kang.kangtemplate.exception;

import com.kang.kangtemplate.common.ErrorCodeEnum;

/**
 * @description: 异常抛出工具类
 * @author: liukang
 * @date: 2024/12/08 14:36:58
 */
public class ThrowUtils {

    /**
     * 如果条件为真，则抛出业务异常
     *
     * @param condition 条件
     * @param errorCode 异常枚举
     */
    public static void throwIf(boolean condition, ErrorCodeEnum errorCode) {
        if (condition) {
            throw new BusinessException(errorCode);
        }
    }

    /**
     * 如果条件为真，则抛出自定义异常消息
     *
     * @param condition 条件
     * @param errorCode 异常枚举
     * @param message   自定义错误消息（优先使用）
     */
    public static void throwIf(boolean condition, ErrorCodeEnum errorCode, String message) {
        if (condition) {
            throw new BusinessException(errorCode.getCode(), message != null ? message : errorCode.getMessage());
        }
    }
}
