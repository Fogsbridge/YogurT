package com.fogsbridge.yogurt.server.common.context;

/**
 * 认证上下文
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public class AuthContext {
    private final Long userId;
    private final String token;

    public AuthContext(Long userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }
}
