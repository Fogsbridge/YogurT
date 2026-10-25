package com.fogsbridge.yogurt.server.interceptor;

import com.fogsbridge.yogurt.server.common.annotation.NoAuthRequired;
import com.fogsbridge.yogurt.server.common.context.AuthContext;
import com.fogsbridge.yogurt.server.common.context.AuthContextHolder;
import com.fogsbridge.yogurt.server.common.enums.ResultCode;
import com.fogsbridge.yogurt.server.common.exception.BusinessException;
import com.fogsbridge.yogurt.server.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * 认证拦截器
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    private final TokenService tokenService;

    public AuthInterceptor(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) {

        // 放行预检请求
        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            return true;
        }

        // 放行非 Controller 请求
        if (!(handler instanceof HandlerMethod handlerMethod)) {
            return true;
        }

        // 放行不需要认证的接口
        if (handlerMethod.hasMethodAnnotation(NoAuthRequired.class)) {
            return true;
        }

        // 没有携带 Authorization 请求头则抛未登录异常
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (header == null || header.isBlank()) {
            throw new BusinessException(ResultCode.NOT_LOGGED_IN);
        }

        // 没有带 Bearer 前缀则抛 Token 无效异常
        final String PREFIX = "Bearer ";
        if (!header.startsWith(PREFIX)) {
            throw new BusinessException(ResultCode.INVALID_TOKEN);
        }

        // 提取 token，解析用户 id，存入上下文
        String token = header.substring(PREFIX.length()).trim();
        Long userId = tokenService.resolve(token);
        AuthContextHolder.set(new AuthContext(userId, token));
        return true;
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request,
                                @NonNull HttpServletResponse response,
                                @NonNull Object handler,
                                Exception ex) {
        AuthContextHolder.clear();
    }
}