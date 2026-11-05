package com.fogsbridge.yogurt.server.common.enums;

/**
 * 文件状态枚举类
 * <p>
 * 对应表 {@code file_record} 字段 {@code status}
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public enum FileStatus implements BaseEnum<Integer> {
    CHECKING(0, "审核中"),
    PENDING(1, "待审核"),
    PUBLISHED(2, "已发布");

    private final Integer value;
    private final String description;

    FileStatus(Integer value, String description) {
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
