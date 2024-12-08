package com.kang.kangtemplate.common;

import lombok.Data;

/**
 * @description: 通用响应类
 * @author: liukang
 * @date: 2024/12/08 14:39:24
 */
@Data
public class BaseResponse<T> {

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 时间戳
     */
    private long timestamp;

    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }
}