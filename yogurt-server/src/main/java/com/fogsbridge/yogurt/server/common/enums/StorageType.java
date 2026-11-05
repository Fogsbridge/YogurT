package com.fogsbridge.yogurt.server.common.enums;

/**
 * 存储类型枚举类
 * <p>
 * 对应表 {@code storage_config} 字段 {@code storage_type}
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public enum StorageType implements BaseEnum<String> {
    LOCAL("Local", "本地存储"),
    RUSTFS("RustFS", "RustFS");

    private final String value;
    private final String description;

    StorageType(String value, String description) {
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
