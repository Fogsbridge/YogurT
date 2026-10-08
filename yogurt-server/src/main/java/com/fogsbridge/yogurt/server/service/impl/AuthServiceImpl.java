package com.fogsbridge.yogurt.server.service.impl;

import com.fogsbridge.yogurt.server.common.enums.ResultCode;
import com.fogsbridge.yogurt.server.common.exception.BusinessException;
import com.fogsbridge.yogurt.server.model.dto.RegisterDTO;
import com.fogsbridge.yogurt.server.model.entity.User;
import com.fogsbridge.yogurt.server.mapper.UserMapper;
import com.fogsbridge.yogurt.server.service.AuthService;
import com.fogsbridge.yogurt.server.service.TokenService;
import com.fogsbridge.yogurt.server.model.vo.AuthVO;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 认证 业务层实现类
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@Service
public class AuthServiceImpl implements AuthService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @Override
    @Transactional
    public AuthVO register(RegisterDTO dto) {
        /*
            TODO: 这里有并发问题，可能会有多个请求同时通过 userMapper.countAll() > 0 此条件。
         */
        // 若已有用户，则关闭注册，只允许初始化第一个用户
        if (userMapper.countAll() > 0) {
            throw new BusinessException(ResultCode.REGISTER_CLOSE);
        }

        // 拷贝 dto 到 entity
        User user = new User();
        BeanUtils.copyProperties(dto, user);

        // 密码哈希（Argon2）处理
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // 存入数据库
        try {
            userMapper.insert(user);
        } catch (DuplicateKeyException e) {
            String msg = e.getMessage();
            // 根据唯一约束判断用户名是否存在，存在则抛异常
            if (msg.contains("uk_username")) {
                throw new BusinessException(ResultCode.USERNAME_EXISTS);
            }
            // 根据唯一约束判断邮箱是否存在，存在则抛异常
            if (msg.contains("uk_email")) {
                throw new BusinessException(ResultCode.EMAIL_EXISTS);
            }
            // 其他重复键冲突，抛服务端异常
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }

        // 生成 token
        String token = tokenService.generate(user.getId());
        return new AuthVO(token);
    }
}
