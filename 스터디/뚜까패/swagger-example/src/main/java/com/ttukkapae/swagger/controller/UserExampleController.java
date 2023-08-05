package com.ttukkapae.swagger.controller;

import com.ttukkapae.swagger.dto.UserExampleRequestDto;
import com.ttukkapae.swagger.dto.UserExampleResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ttukkapae")
@Tag(name = "사용자 예제 API", description = "사용자와 관련된 API 예제 입니다.")
public class UserExampleController {

    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "사용자가 올바른 ID와 PW를 입력했다면 회원가입을 시도합니다.")
    public ResponseEntity<UserExampleResponseDto> signup(@RequestBody UserExampleRequestDto exampleDto) {
        return  ResponseEntity.ok().body(new UserExampleResponseDto());
    }

    @GetMapping("/user/{id}")
    @Operation(summary = "사용자 1명의 정보를 접근", description = "사용자의 ID를 통해, 해당 사용자의 정보에 접근합니다.")
    public ResponseEntity<UserExampleResponseDto> getUser(@PathVariable Long id) {
        return  ResponseEntity.ok().body(new UserExampleResponseDto());
    }
}
