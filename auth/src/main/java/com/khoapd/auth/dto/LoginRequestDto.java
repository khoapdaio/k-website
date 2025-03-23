package com.khoapd.auth.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
    private boolean rememberMe;
    private String totp;
}
