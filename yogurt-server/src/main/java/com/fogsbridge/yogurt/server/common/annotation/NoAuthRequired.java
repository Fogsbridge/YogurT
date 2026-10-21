package com.fogsbridge.yogurt.server.common.annotation;

import java.lang.annotation.*;

/**
 * 无需认证注解
 *
 * @author fogsbridge
 * @since 1.0.0
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoAuthRequired {}
