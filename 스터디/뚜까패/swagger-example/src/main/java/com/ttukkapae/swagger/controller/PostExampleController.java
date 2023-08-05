package com.ttukkapae.swagger.controller;

import com.ttukkapae.swagger.dto.ApiExampleResponseDto;
import com.ttukkapae.swagger.dto.PostExampleDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ttukkapae")
@Tag(name = "게시글 예제 API", description = "게시글과 관련된 API 예제 입니다.")
public class PostExampleController {
    @PostMapping("/post")
    @Operation(summary = "게시글 생성", description = "DTO로부터 정보를 받아와, 게시글을 생성합니다.")
    public ResponseEntity<PostExampleDto> createPost(@RequestBody PostExampleDto exampleDto) {
        return ResponseEntity.ok().body(new PostExampleDto());
    }

    @GetMapping("/posts")
    @Operation(summary = "모든 게시글 조회", description = "생성된 모든 게시글을 조회합니다.")
    public List<PostExampleDto> getPosts() {
        return new ArrayList<>();
    }

    @GetMapping("/posts/{id}")
    @Operation(summary = "게시글 1개 조회", description = "게시글 고유 id를 사용해 해당 게시글을 조회합니다.")
    public ResponseEntity<PostExampleDto> getBlogPost(@PathVariable Long id) {
        return ResponseEntity.ok().body(new PostExampleDto());
    }

    @PutMapping("/posts/{id}")
    @Operation(summary = "선택한 게시글 수정", description = "게시글 고유 id를 사용해 해당 게시글을 수정합니다.")
    public ResponseEntity<PostExampleDto> updateBlogPost(
            @PathVariable Long id,
            @RequestBody PostExampleDto exampleDto
    ) {
        return ResponseEntity.ok().body(new PostExampleDto());
    }

    @DeleteMapping("/posts/{id}")
    @Operation(summary = "선택한 게시글 삭제", description = "게시글 고유 id를 사용해 해당 게시글을 삭제합니다.")
    public ResponseEntity<ApiExampleResponseDto> deleteBlogPost(@PathVariable Long id, HttpServletResponse res) {
        return ResponseEntity.ok().body(new ApiExampleResponseDto());
    }
}
