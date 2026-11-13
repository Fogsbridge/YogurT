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
    PENDING(1, "待处理"),
    NORMAL(2, "正常"),
    DELETED(3, "已删除"),
    REJECTED(4, "已拒绝");

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
