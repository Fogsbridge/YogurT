package com.fogsbridge.yogurt.server.service;

import com.fogsbridge.yogurt.server.dto.RegisterDTO;

/**
 * 用户 业务层
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public interface UserService {
    void register(RegisterDTO dto);
}
