package com.ttukkapae.example.dto;

import com.ttukkapae.example.entity.Test;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class TestDtos { // TestDto 매핑 클래스
    private List<TestDto> testDtos = new ArrayList<>();

    public TestDtos(List<TestDto> testDtos) {
        this.testDtos = testDtos;
    }
}
