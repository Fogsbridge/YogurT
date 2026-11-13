package com.fogsbridge.yogurt.server.mapper;

import com.fogsbridge.yogurt.server.model.entity.StorageBucket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 存储桶 mapper
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@Mapper
public interface StorageBucketMapper {
    String UK_NAME_SOURCE = "uk_name_source";
    String UK_ACCESS_SOURCE = "uk_access_source";

    Integer insert(StorageBucket bucket);

    StorageBucket selectById(@Param("id") Long id);

    StorageBucket selectByBucketNameAndBuiltin(@Param("bucketName") String bucketName, @Param("builtin") Boolean builtin);

}
