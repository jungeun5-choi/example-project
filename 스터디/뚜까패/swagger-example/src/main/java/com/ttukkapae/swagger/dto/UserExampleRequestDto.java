package com.ttukkapae.swagger.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserExampleRequestDto {
    private String username;
    private String password;

    public UserExampleRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
