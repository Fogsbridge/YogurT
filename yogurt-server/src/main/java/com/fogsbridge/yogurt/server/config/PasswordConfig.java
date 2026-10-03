package com.fogsbridge.yogurt.server.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 密码相关 配置类
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(Argon2Properties.class)
public class PasswordConfig {
    private final Argon2Properties argon2Properties;

    public PasswordConfig(Argon2Properties argon2Properties) {
        this.argon2Properties = argon2Properties;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Argon2PasswordEncoder(
                argon2Properties.getSaltLength(),
                argon2Properties.getHashLength(),
                argon2Properties.getParallelism(),
                argon2Properties.getMemory(),
                argon2Properties.getIterations()
        );
    }
}
