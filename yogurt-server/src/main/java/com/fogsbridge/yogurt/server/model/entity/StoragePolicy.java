package com.fogsbridge.yogurt.server.model.entity;

import com.fogsbridge.yogurt.server.common.enums.FileType;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * storage_policy entity
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public class StoragePolicy {
    private Long id;
    private Long configId;
    private String policyName;
    private FileType fileType;
    private String basePath;
    private Boolean privateFlag;
    private Long maxSize;
    private Long chunkSize;
    private Set<String> allowedTypes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public Boolean getPrivateFlag() {
        return privateFlag;
    }

    public void setPrivateFlag(Boolean privateFlag) {
        this.privateFlag = privateFlag;
    }

    public Long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Long maxSize) {
        this.maxSize = maxSize;
    }

    public Long getChunkSize() {
        return chunkSize;
    }

    public void setChunkSize(Long chunkSize) {
        this.chunkSize = chunkSize;
    }

    public Set<String> getAllowedTypes() {
        return allowedTypes;
    }

    public void setAllowedTypes(Set<String> allowed_types) {
        this.allowedTypes = allowed_types;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
