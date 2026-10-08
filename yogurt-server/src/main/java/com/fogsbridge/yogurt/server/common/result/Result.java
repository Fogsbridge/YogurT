package com.fogsbridge.yogurt.server.common.result;

import com.fogsbridge.yogurt.server.common.enums.ResultCode;

/**
 * 封装响应结果
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public record Result<T>(int code, String message, T data) {

    public static <T> Result<T> success() {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> fail(ResultCode resultCode) {
        return new Result<>(resultCode.getCode(), resultCode.getMessage(), null);
    }

    public static <T> Result<T> fail(int code, String message) {
        return new Result<>(code, message, null);
    }

}
