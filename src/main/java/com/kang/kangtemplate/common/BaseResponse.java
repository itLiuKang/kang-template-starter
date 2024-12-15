package com.kang.kangtemplate.common;

import com.kang.kangtemplate.utils.date.DateUtils;
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
     * 日期、时间
     */
    private String dateTime;

    public BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.dateTime = DateUtils.convertTimestampToDate(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss");
    }
}