package com.fogsbridge.yogurt.server.mapper;

import com.fogsbridge.yogurt.server.model.entity.StorageConfig;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 存储配置 mapper
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@Mapper
public interface StorageConfigMapper {
    Integer insert(StorageConfig config);

    StorageConfig selectById(@Param("id") Long id);
}
