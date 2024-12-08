package com.kang.kangtemplate.exception;

import com.kang.kangtemplate.common.BaseResponse;
import com.kang.kangtemplate.common.ErrorCodeEnum;
import com.kang.kangtemplate.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @description: 全局异常处理器
 * @author: liukang
 * @date: 2024/12/08 14:33:57
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponse<Void> handleBusinessException(BusinessException ex) {
        log.error("业务异常: code={}, message={}", ex.getCode(), ex.getMessage());
        return ResultUtils.error(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public BaseResponse<Void> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("非法参数异常: {}", ex.getMessage());
        return ResultUtils.error(ErrorCodeEnum.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse<Void> handleException(Exception ex) {
        log.error("系统异常: {}", ex.getMessage(), ex);
        return ResultUtils.error(ErrorCodeEnum.INTERNAL_SERVER_ERROR);
    }
}