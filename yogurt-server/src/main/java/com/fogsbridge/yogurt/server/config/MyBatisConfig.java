package com.fogsbridge.yogurt.server.config;

import com.fogsbridge.yogurt.server.handler.mybatis.TinyIntBooleanTypeHandler;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis 配置类
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer typeHandlerCustomizer() {
        return configuration -> {
            TinyIntBooleanTypeHandler handler = new TinyIntBooleanTypeHandler();
            configuration.getTypeHandlerRegistry().register(Boolean.class, handler);
            configuration.getTypeHandlerRegistry().register(boolean.class, handler);
        };
    }
}
