package com.fogsbridge.yogurt.server.mapper;

import com.fogsbridge.yogurt.server.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户 数据持久层
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@Mapper
public interface UserMapper {
    Long countAll();

    Boolean existsByUsername(@Param("username") String username);

    Boolean existsByEmail(@Param("email") String email);

    void insert(User user);
}
