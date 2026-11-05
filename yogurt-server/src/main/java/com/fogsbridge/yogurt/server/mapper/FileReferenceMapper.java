package com.fogsbridge.yogurt.server.mapper;

import com.fogsbridge.yogurt.server.model.entity.FileReference;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 文件引用 mapper
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@Mapper
public interface FileReferenceMapper {
    Integer insert(FileReference reference);

    FileReference selectById(@Param("id") Long id);
}
