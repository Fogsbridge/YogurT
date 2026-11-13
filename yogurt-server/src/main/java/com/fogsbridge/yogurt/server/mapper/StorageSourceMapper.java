package com.fogsbridge.yogurt.server.mapper;

import com.fogsbridge.yogurt.server.model.entity.StorageSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 存储源 mapper
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@Mapper
public interface StorageSourceMapper {
    String UK_ENDPOINT = "uk_endpoint";
    String UK_SOURCE_NAME = "uk_source_name";

    Integer insert(StorageSource source);

    StorageSource selectById(@Param("id") Long id);

    StorageSource selectBySourceNameAndBuiltin(@Param("sourceName") String sourceName, @Param("builtin") Boolean builtin);

    StorageSource selectByEndpoint(@Param("endpoint") String endpoint);
}
