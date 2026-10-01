package com.fogsbridge.yogurt.server.common.enums;

/**
 * 业务状态码
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public enum ResultCode {
    SUCCESS(200,200, "成功"),

    SERVER_ERROR(500,500, "服务器内部错误"),

    USERNAME_EXISTS(409,1001, "用户名已被注册"),
    EMAIL_EXISTS(409,1002, "邮箱已被注册"),
    REGISTER_CLOSE(403,1003, "关闭注册");

    // http 状态码
    private final int httpCode;
    // 业务状态码
    private final int code;
    // 描述信息
    private final String message;

    ResultCode(int httpCode, int code, String message) {
        this.httpCode = httpCode;
        this.code = code;
        this.message = message;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
