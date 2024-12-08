package com.kang.kangtemplate.exception;

import com.kang.kangtemplate.common.ErrorCodeEnum;
import lombok.Getter;

/**
 * @description: 自定义业务异常
 * @author: liukang
 * @date: 2024/12/08 14:34:26
 */
@Getter
public class BusinessException extends RuntimeException {
    private final int code;

    public BusinessException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.code = errorCodeEnum.getCode();
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }
}
