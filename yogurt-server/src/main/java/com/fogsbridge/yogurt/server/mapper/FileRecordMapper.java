package com.fogsbridge.yogurt.server.mapper;

import com.fogsbridge.yogurt.server.model.entity.FileRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 文件记录 mapper
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@Mapper
public interface FileRecordMapper {
    Integer insert(FileRecord record);

    FileRecord selectById(@Param("id") Long id);
}