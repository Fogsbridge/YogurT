package com.fogsbridge.yogurt.server.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 注册 DTO
 *
 * @author fogsbridge
 * @since 1.0.0
 */
public class RegisterDTO {
    @NotBlank(message = "用户名不能为空")
    @Size(min = 1, max = 32, message = "用户名长度应为 1-32")
    private String username;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String email;

    @NotNull(message = "密码不能为空")
    @Size(min = 6, max = 64, message = "密码长度应为 6-64")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
