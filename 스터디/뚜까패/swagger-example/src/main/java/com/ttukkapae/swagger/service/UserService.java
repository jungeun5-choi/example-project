package com.ttukkapae.swagger.service;

import com.ttukkapae.swagger.Entity.User;
import com.ttukkapae.swagger.dto.ApiResponseDto;
import com.ttukkapae.swagger.dto.SignupRequestDto;
import com.ttukkapae.swagger.dto.UserResponseDto;
import com.ttukkapae.swagger.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ApiResponseDto signup(SignupRequestDto requestDto, HttpServletResponse res) {
        String username = requestDto.getUsername();
        String password = passwordEncoder.encode(requestDto.getPassword());

        // username 중복 확인
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        // 사용자 DB에 등록
        userRepository.save(new User(username, password));

        ApiResponseDto statusResponseDto = new ApiResponseDto("회원가입 성공", res.getStatus());
        return statusResponseDto;

    }

    @Transactional(readOnly = true)
    public UserResponseDto getUser(Long id) {
        User findUser = userRepository.findById(id).orElseThrow(()->
                new RuntimeException("해당 Id를 찾을 수 없습니다. user Id: " + id)
        );
        return new UserResponseDto(findUser);
    }
}
