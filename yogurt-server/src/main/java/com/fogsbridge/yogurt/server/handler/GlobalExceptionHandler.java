package com.fogsbridge.yogurt.server.handler;

import com.fogsbridge.yogurt.server.common.enums.ResultCode;
import com.fogsbridge.yogurt.server.common.exception.BusinessException;
import com.fogsbridge.yogurt.server.common.result.Result;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局异常处理器
 * <p>
 * 统一处理所有异常并以 {@link Result} 包装
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
     * @return 返回以 {@link Result} 包装的业务错误信息
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Result<Void>> handleBusinessException(BusinessException e) {
        ResultCode rc = e.getResultCode();
        return ResponseEntity.status(rc.getHttpCode()).body(Result.fail(rc));
    }

    /**
     * 处理如 {@link org.springframework.web.bind.annotation.RequestParam} 、 {@link org.springframework.web.bind.annotation.PathVariable} 等注解的参数校验失败
     *
     * @param e 捕获到的异常
     * @return 返回以 {@link Result} 包装的参数错误信息
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Result<Void>> handleConstraintViolationException(ConstraintViolationException e) {
        String msg = e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .findFirst()
                .orElse(ResultCode.PARAMETER_ERROR.getMessage());

        return ResponseEntity.status(ResultCode.PARAMETER_ERROR.getHttpCode())
                .body(Result.fail(ResultCode.PARAMETER_ERROR.getCode(), msg));
    }

    /**
     * 处理通用异常
     * <p>
     * 负责兜底，处理未被其他处理器匹配的异常，统一返回 {@link ResultCode#SERVER_ERROR } (500)
     *
     * @param e 捕获到的异常
     * @return 返回以 {@link Result} 包装的意料之外的错误信息
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result<Void>> handleException(Exception e) {
        return ResponseEntity.status(ResultCode.SERVER_ERROR.getHttpCode())
                .body(Result.fail(ResultCode.SERVER_ERROR));
    }

    /**
     * 处理 Spring 内置异常
     * <p>
     * 对于已重写内置异常（如 {@link handleMethodArgumentNotValid}）会走对应的逻辑，未被重写的内置异常走此方法
     * <p>
     * 由于 Spring 部分内置异常的描述信息（{@link Exception#getMessage()}）可能暴露系统内部敏感信息，转而统一使用 {@link ProblemDetail#getTitle()} 作为响应
     *
     * @param ex 捕获到的异常
     * @param body 响应体
     * @param headers 响应头
     * @param statusCode HTTP 状态码
     * @param request 当前请求
     * @return 返回以 {@link Result} 包装的 Spring 内置异常错误信息
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            @NonNull Exception ex,
            @Nullable Object body,
            @NonNull HttpHeaders headers,
            HttpStatusCode statusCode,
            @NonNull WebRequest request
    ) {
        Result<Void> result = Result.fail(statusCode.value(), ProblemDetail.forStatus(statusCode).getTitle());
        return new ResponseEntity<>(result, headers, statusCode);
    }

    /**
     * 处理如 {@link org.springframework.web.bind.annotation.RequestBody} 、 {@link org.springframework.web.bind.annotation.ModelAttribute} 等注解的参数校验失败
     *
     * @param ex 捕获到的异常
     * @param headers 响应头
     * @param status the selected response status
     * @param request 当前请求
     * @return 返回以 {@link Result} 包装的参数错误信息
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            @NonNull HttpHeaders headers,
            @NonNull HttpStatusCode status,
            @NonNull WebRequest request
    ) {

        FieldError fieldError = ex.getBindingResult().getFieldError();
        String msg = fieldError != null ? fieldError.getDefaultMessage() : ResultCode.PARAMETER_ERROR.getMessage();

        return ResponseEntity.status(ResultCode.PARAMETER_ERROR.getHttpCode())
                .headers(headers)
                .body(Result.fail(ResultCode.PARAMETER_ERROR.getCode(), msg));
    }
}
