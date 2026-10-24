package com.fogsbridge.yogurt.server.controller;

import com.fogsbridge.yogurt.server.common.annotation.NoAuthRequired;
import com.fogsbridge.yogurt.server.common.result.Result;
import com.fogsbridge.yogurt.server.model.dto.LoginDTO;
import com.fogsbridge.yogurt.server.model.dto.RegisterDTO;
import com.fogsbridge.yogurt.server.service.AuthService;
import com.fogsbridge.yogurt.server.model.vo.AuthVO;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

/**
 * 认证 表现层
 *
 * @author fogsbridge
 * @since 1.0.0
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @NoAuthRequired
    public Result<AuthVO> register(@RequestBody @Valid RegisterDTO dto) {
        AuthVO vo = authService.register(dto);
        return Result.success(vo);
    }

    @PostMapping("/login")
    @NoAuthRequired
    public Result<AuthVO> login(@RequestBody @Valid LoginDTO dto) {
        AuthVO vo = authService.login(dto);
        return Result.success(vo);
    }

    @PostMapping("/logout")
    @NoAuthRequired
    public Result<Void> logout(@RequestHeader(name = HttpHeaders.AUTHORIZATION, required = false) String header) {
        // 无论是否携带有效 token 都返回成功
        final String PREFIX = "Bearer ";
        String token = null;
        if (header != null && header.startsWith(PREFIX)) {
            token = header.substring(PREFIX.length()).trim();
        }

        authService.logout(token);
        return Result.success();
    }
}
