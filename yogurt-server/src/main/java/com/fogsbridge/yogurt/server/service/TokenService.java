package com.fogsbridge.yogurt.server.service;

/**
 * token
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public interface TokenService {
    String generate(Long userId);

    Long resolve(String token);

    void revoke(String token);
}
