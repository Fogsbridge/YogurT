package com.fogsbridge.yogurt.server.common.enums;

/**
 * 关联目标类型枚举类
 * <p>
 * 对应表 {@code file_reference} 字段 {@code target_type}
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public enum TargetType implements BaseEnum<String> {
    POST("post", "文章"),
    COMMENT("comment", "评论");

    private final String value;
    private final String description;

    TargetType(String value, String description) {
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
