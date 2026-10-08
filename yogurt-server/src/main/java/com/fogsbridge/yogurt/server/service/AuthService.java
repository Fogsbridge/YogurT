package com.fogsbridge.yogurt.server.service;

import com.fogsbridge.yogurt.server.model.dto.RegisterDTO;
import com.fogsbridge.yogurt.server.model.vo.AuthVO;

/**
 * 认证 业务层
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public interface AuthService {
    AuthVO register(RegisterDTO dto);
}
