package com.ttukkapae.swagger.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupRequestDto {
    @NotNull
    @Pattern(regexp = "^(?=.*[a-z])(?=.*\\d).{4,10}+$", message = "최소 4자 이상, 10자 이하이며 알파벳 소문자(a~z), 숫자(0~9) 사용.")
    private String username;
    @NotNull
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^*+=-]).{8,15}+$", message = "최소 8자 이상, 15자 이하이며 알파벳 대소문자(a~z, A~Z), 숫자(0~9), 특수문자(!@#$%^*+=-)를 1개 이상 사용.")
    private String password;
}
