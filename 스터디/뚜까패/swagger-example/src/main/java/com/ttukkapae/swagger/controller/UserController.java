package com.ttukkapae.swagger.controller;

import com.ttukkapae.swagger.dto.ApiResponseDto;
import com.ttukkapae.swagger.dto.SignupRequestDto;
import com.ttukkapae.swagger.dto.UserResponseDto;
import com.ttukkapae.swagger.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ttukkapae")
@Tag(name = "사용자 예제 API", description = "사용자와 관련된 API 예제 입니다.")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "사용자가 올바른 ID와 PW를 입력했다면 회원가입을 시도합니다.")
    public ResponseEntity<ApiResponseDto> signup(@RequestBody SignupRequestDto requestDto, HttpServletResponse res) {
        ApiResponseDto result = userService.signup(requestDto, res);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/user/{id}")
    @Operation(summary = "사용자 1명의 정보를 접근", description = "사용자의 ID를 통해, 해당 사용자의 정보에 접근합니다.")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {
        UserResponseDto result = userService.getUser(id);
        return ResponseEntity.ok().body(result);
    }
}
