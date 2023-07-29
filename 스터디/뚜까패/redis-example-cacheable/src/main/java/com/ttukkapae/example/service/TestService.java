package com.ttukkapae.example.service;

import com.ttukkapae.example.dto.TestDto;
import com.ttukkapae.example.dto.TestDtos;
import com.ttukkapae.example.entity.Test;
import com.ttukkapae.example.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    @Transactional
    public TestDto createContent(TestDto testDto) {
        Test test = new Test(testDto);
        testRepository.save(test);
        return new TestDto(test);
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "contents", key = "#username", cacheManager = "redisCacheManager")
    public TestDtos getAllUserContents(String username) {
        List<Test> tests = testRepository.findAllByUsername(username);
        List<TestDto> testDtos = tests.stream().map(TestDto::new).toList();
        return new TestDtos(testDtos);
    }
}
