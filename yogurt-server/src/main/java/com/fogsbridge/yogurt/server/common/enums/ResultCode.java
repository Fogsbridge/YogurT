package com.fogsbridge.yogurt.server.common.enums;

import org.springframework.http.HttpStatus;

/**
 * 响应状态码
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public enum ResultCode {
    // 通用
    SUCCESS(HttpStatus.OK, 2000, "成功"),
    PARAMETER_ERROR(HttpStatus.BAD_REQUEST, 4000, "参数错误"),
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 5000, "服务器内部错误"),

    // 注册业务错误 (10xxx)
    USERNAME_EXISTS(HttpStatus.CONFLICT, 10001, "用户名已被注册"),
    EMAIL_EXISTS(HttpStatus.CONFLICT, 10002, "邮箱已被注册"),
    REGISTER_CLOSE(HttpStatus.FORBIDDEN, 10003, "关闭注册"),

    // 登录业务错误（11xxx)
    LOGIN_FAILED(HttpStatus.UNAUTHORIZED, 11001, "用户名或密码错误");


    // http 状态
    private final HttpStatus httpStatus;
    // 业务状态码
    private final int code;
    // 描述信息
    private final String message;

    ResultCode(HttpStatus httpStatus, int code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
