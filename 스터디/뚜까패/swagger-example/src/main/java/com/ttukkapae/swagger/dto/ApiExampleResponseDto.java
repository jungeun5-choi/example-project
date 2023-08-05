package com.ttukkapae.swagger.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ApiExampleResponseDto {
    private String msg;
    private Integer statusCode;

    public ApiExampleResponseDto(String msg, Integer statusCode) {
        this.msg = msg;
        this.statusCode = statusCode;
    }
}
