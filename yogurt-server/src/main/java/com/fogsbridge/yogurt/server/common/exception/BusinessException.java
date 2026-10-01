package com.fogsbridge.yogurt.server.common.exception;

import com.fogsbridge.yogurt.server.common.enums.ResultCode;

/**
 * 业务异常类
 * <p>
 * 封装 ResultCode（状态码、描述信息）
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public class BusinessException extends RuntimeException {
    private final ResultCode resultCode;

    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
