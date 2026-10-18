package com.fogsbridge.yogurt.server.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 登录 DTO
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public class LoginDTO {
    @NotBlank(message = "用户名不能为空")
    @Size(min = 1, max = 128, message = "用户名长度不合法")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Size(min = 1, max = 256, message = "密码长度不合法")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
