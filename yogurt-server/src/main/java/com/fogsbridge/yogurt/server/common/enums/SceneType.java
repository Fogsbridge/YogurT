package com.fogsbridge.yogurt.server.common.enums;

/**
 * 场景类型枚举
 * <p>
 * 对应表 {@code upload_scene} 字段 {@code scene_type}
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public enum SceneType implements BaseEnum<String> {
    AVATAR("avatar", "头像");

    private final String value;
    private final String description;

    SceneType(String value, String description) {
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
