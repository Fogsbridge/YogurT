package com.fogsbridge.yogurt.server.controller;

import com.fogsbridge.yogurt.server.common.result.Result;
import com.fogsbridge.yogurt.server.dto.RegisterDTO;
import com.fogsbridge.yogurt.server.service.UserService;
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
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Result<Void> register(@RequestBody @Valid RegisterDTO dto) {
        userService.register(dto);
        return Result.success();
    }
}
