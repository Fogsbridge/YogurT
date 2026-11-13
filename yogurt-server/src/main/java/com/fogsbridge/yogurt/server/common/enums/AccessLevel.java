package com.fogsbridge.yogurt.server.common.enums;

/**
 * 访问级别枚举类
 * <p>
 * 对应表 {@code storage_bucket} 字段 {@code access_level}
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public enum AccessLevel implements BaseEnum<Integer> {
    PUBLIC(1, "公开"),
    PRIVATE(2, "私有"),
    ISOLATION(3, "隔离");

    private final Integer value;
    private final String description;

    AccessLevel(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
