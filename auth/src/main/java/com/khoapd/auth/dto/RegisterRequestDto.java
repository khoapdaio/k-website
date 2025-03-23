package com.khoapd.auth.dto;

import lombok.Data;

@Data
public class RegisterRequestDto {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String totp;
}
