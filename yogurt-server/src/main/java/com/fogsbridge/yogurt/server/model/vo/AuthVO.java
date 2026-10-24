package com.fogsbridge.yogurt.server.model.vo;

/**
 * 认证 VO
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public class AuthVO {
    private String token;

    public AuthVO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
