package com.fogsbridge.yogurt.server.service.impl;

import com.fogsbridge.yogurt.server.common.enums.ResultCode;
import com.fogsbridge.yogurt.server.common.exception.BusinessException;
import com.fogsbridge.yogurt.server.dto.RegisterDTO;
import com.fogsbridge.yogurt.server.entity.User;
import com.fogsbridge.yogurt.server.mapper.UserMapper;
import com.fogsbridge.yogurt.server.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户 业务层实现类
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void register(RegisterDTO dto) {
        /*
            TODO: 这里有并发问题，可能会有多个请求同时通过 userMapper.countAll() > 0 此条件。
         */
        if (userMapper.countAll() > 0) {
            throw new BusinessException(ResultCode.REGISTER_CLOSE);
        }

        User user = new User();
        BeanUtils.copyProperties(dto, user);

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        try {
            userMapper.insert(user);
        } catch (DuplicateKeyException e) {
            String msg = e.getMessage();
            if (msg.contains("uk_username")) {
                throw new BusinessException(ResultCode.USERNAME_EXISTS);
            }
            if (msg.contains("uk_email")) {
                throw new BusinessException(ResultCode.EMAIL_EXISTS);
            }
            throw new BusinessException(ResultCode.SERVER_ERROR);
        }
    }
}
