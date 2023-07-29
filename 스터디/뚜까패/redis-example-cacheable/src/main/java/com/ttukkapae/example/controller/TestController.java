package com.ttukkapae.example.controller;

import com.ttukkapae.example.dto.TestDto;
import com.ttukkapae.example.dto.TestDtos;
import com.ttukkapae.example.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ttukkapae")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @PostMapping("/content")
    public TestDto createContent(
            @RequestBody TestDto testDto
    ) {
        return testService.createContent(testDto);
    }

    @GetMapping("/contents")
    public TestDtos getAllUserContents(
            @RequestParam(value = "username") String username
    ) {
        return testService.getAllUserContents(username);
    }
}
