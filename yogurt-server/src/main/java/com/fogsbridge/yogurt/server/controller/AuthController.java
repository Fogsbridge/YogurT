package com.fogsbridge.yogurt.server.controller;

import com.fogsbridge.yogurt.server.common.result.Result;
import com.fogsbridge.yogurt.server.model.dto.RegisterDTO;
import com.fogsbridge.yogurt.server.service.AuthService;
import com.fogsbridge.yogurt.server.model.vo.AuthVO;
import jakarta.validation.Valid;
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
    public Result<AuthVO> register(@RequestBody @Valid RegisterDTO dto) {
        AuthVO vo = authService.register(dto);
        return Result.success(vo);
    }
}
