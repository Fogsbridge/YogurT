package com.fogsbridge.yogurt.server.common.enums;

/**
 * 衍生文件枚举类
 * <p>
 * 对应表 {@code file_record} 字段 {@code file_variant}
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public enum FileVariant implements BaseEnum<String> {
    ORIGINAL("original", "原文件"),
    THUMBNAIL("thumbnail", "缩略图"),
    COMPRESSED("compressed", "压缩图");

    private final String value;
    private final String description;

    FileVariant(String value, String description) {
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
