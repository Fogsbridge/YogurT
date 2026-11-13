package com.fogsbridge.yogurt.server.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 本地存储配置属性
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@Component
@ConfigurationProperties("yogurt.storage.local")
public class LocalStorageProperties {
    private String rootPath;

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }
}
