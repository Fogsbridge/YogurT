package com.fogsbridge.yogurt.server.common.enums;

/**
 * 关联引用业务类型枚举类
 * <p>
 * 对应表 {@code file_reference} 字段 {@code ref_type}
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public enum RefType implements BaseEnum<String> {
    USER_AVATAR("user-avatar", "用户头像");

    private final String value;
    private final String description;

    RefType(String value, String description) {
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
