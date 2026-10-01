package com.fogsbridge.yogurt.server.handler;

import com.fogsbridge.yogurt.server.common.enums.ResultCode;
import com.fogsbridge.yogurt.server.common.exception.BusinessException;
import com.fogsbridge.yogurt.server.common.result.Result;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局异常处理器
 * <p>
 * 统一处理所有异常并以 Result 包装
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * 处理业务异常
     *
     * @param e 捕获到的异常
     * @return 返回以 Result 包装的业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Result<Void>> handleBusinessException(BusinessException e) {
        ResultCode rc = e.getResultCode();
        return ResponseEntity.status(rc.getHttpCode()).body(Result.fail(rc));
    }

    /**
     * 处理通用异常
     * <p>
     * 负责兜底，处理未被其他处理器匹配的异常，统一返回 SERVER_ERROR(500)
     *
     * @param e 捕获到的异常
     * @return 返回以 Result 包装的意料之外的异常，返回 SERVER_ERROR
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result<Void>> handleException(Exception e) {
        return ResponseEntity.status(ResultCode.SERVER_ERROR.getHttpCode())
                .body(Result.fail(ResultCode.SERVER_ERROR));
    }

    /**
     * 处理 Spring 内置异常
     *
     * @param ex 捕获到的异常
     * @param body 响应体
     * @param headers 响应头
     * @param statusCode HTTP 状态码
     * @param request 当前请求
     * @return 返回以 Result 包装的 Spring 内置异常
     */
    @Override
    protected @Nullable ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        Result<Void> result = Result.fail(statusCode.value(), ex.getMessage());
        return new ResponseEntity<>(result, headers, statusCode);
    }
}
