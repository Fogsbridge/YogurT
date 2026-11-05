package com.fogsbridge.yogurt.server.common.enums;

/**
 * 文件类型枚举类
 * <p>
 * 对应表 {@code storage_policy} 字段 {@code file_type}
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public enum FileType implements BaseEnum<String> {
    IMAGE("image","图片"),
    VIDEO("video","视频"),
    AUDIO("audio","音频");

    private final String value;
    private final String description;

    FileType(String value, String description) {
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
