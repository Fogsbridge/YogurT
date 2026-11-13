package com.fogsbridge.yogurt.server.common.enums;

/**
 * 拒绝原因枚举
 * <p>
 * 对应表 {@code file_record} 字段 {@code reject_reason}
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public enum RejectReason implements BaseEnum<String> {
    INVALID_FORMAT("invalid_format", "文件格式不支持"),
    MALWARE("malware", "恶意文件"),
    CONTENT_VIOLATION("content_violation", "内容违规");

    private final String value;
    private final String description;

    RejectReason(String value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
