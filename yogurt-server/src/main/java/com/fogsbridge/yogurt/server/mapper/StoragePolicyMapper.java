package com.fogsbridge.yogurt.server.mapper;

import com.fogsbridge.yogurt.server.model.entity.StoragePolicy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 存储策略 mapper
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@Mapper
public interface StoragePolicyMapper {
    Long insert(StoragePolicy policy);

    StoragePolicy selectById(@Param("id") Long id);
}
