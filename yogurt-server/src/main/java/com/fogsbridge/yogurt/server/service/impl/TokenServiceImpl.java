package com.fogsbridge.yogurt.server.service.impl;

import com.fogsbridge.yogurt.server.common.enums.ResultCode;
import com.fogsbridge.yogurt.server.common.exception.BusinessException;
import com.fogsbridge.yogurt.server.service.TokenService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.Base64;

/**
 * token 管理
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@Service
public class TokenServiceImpl implements TokenService {
    private final String TOKEN_PREFIX = "auth:user:token:";
    private final Duration TTL = Duration.ofDays(7);
    private final SecureRandom secureRandom = new SecureRandom();
    private final StringRedisTemplate redisTemplate;

    public TokenServiceImpl(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public String generate(Long userId) {
        // 生成 token
        byte[] bytes = new byte[32];
        secureRandom.nextBytes(bytes);
        String token = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
        // 存入 redis
        redisTemplate.opsForValue().set(TOKEN_PREFIX + token, String.valueOf(userId), TTL);
        return token;
    }

    @Override
    public Long resolve(String token) {
        // token 空值，抛 Token 无效异常
        if (token == null || token.isBlank()) {
            throw new BusinessException(ResultCode.INVALID_TOKEN);
        }

        // 没查询到用户，抛登陆过期异常
        String userId = redisTemplate.opsForValue().get(TOKEN_PREFIX + token);
        if (userId == null) {
            throw new BusinessException(ResultCode.LOGIN_EXPIRED);
        }

        return Long.valueOf(userId);
    }

    @Override
    public void revoke(String token) {
        redisTemplate.delete(token);
    }
}