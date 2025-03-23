package com.khoapd.account.dto;

import com.khoapd.core.dto.request.BaseRequestDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AccountRequestDto extends BaseRequestDto {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
    @Size(max = 50)
    private String nickname;
    @Size(max = 200)
    private String avatar_url;
    @Size(max = 50)
    @NotBlank
    private String email;
    @Size(max = 50)
    private String phone;

}
