package com.kang.kangtemplate.common;

import lombok.Getter;

/**
 * @description: 错误代码枚举
 * @author: liukang
 * @date: 2024/12/08 14:24:11
 */
@Getter
public enum ErrorCodeEnum {

    // 通用错误
    SUCCESS(200, "操作成功"),
    BAD_REQUEST(400, "请求参数有误"),
    UNAUTHORIZED(401, "未经授权"),
    FORBIDDEN(403, "没有权限访问"),
    NOT_FOUND(404, "资源未找到"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),

    // 自定义业务错误
    USER_NOT_FOUND(1001, "用户不存在"),
    DATA_VALIDATION_FAILED(1002, "数据校验失败"),
    OPERATION_NOT_ALLOWED(1003, "操作不被允许"),
    DUPLICATE_ENTRY(1004, "重复的记录");

    // 错误代码
    private final int code;

    // 错误描述
    private final String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
