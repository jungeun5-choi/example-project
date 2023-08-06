package com.ttukkapae.swagger.controller;

import com.ttukkapae.swagger.dto.ApiResponseDto;
import com.ttukkapae.swagger.dto.PostDto;
import com.ttukkapae.swagger.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ttukkapae")
@Tag(name = "게시글 예제 API", description = "게시글과 관련된 API 예제 입니다.")
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    @Operation(summary = "게시글 생성", description = "DTO로부터 정보를 받아와, 게시글을 생성합니다.")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto requestDto) {
        PostDto result = postService.createPost(requestDto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/posts")
    @Operation(summary = "모든 게시글 조회", description = "생성된 모든 게시글을 조회합니다.")
    public ResponseEntity<List<PostDto>> getPosts() {
        List<PostDto> results = postService.getPosts();
        return ResponseEntity.ok().body(results);
    }

    @GetMapping("/posts/{id}")
    @Operation(summary = "게시글 1개 조회", description = "게시글 고유 id를 사용해 해당 게시글을 조회합니다.")
    public ResponseEntity<PostDto> getPost(@PathVariable Long id) {
        PostDto result = postService.getPost(id);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/posts/{id}")
    @Operation(summary = "선택한 게시글 수정", description = "게시글 고유 id를 사용해 해당 게시글을 수정합니다.")
    public ResponseEntity<PostDto> updatePost(
            @PathVariable Long id,
            @RequestBody PostDto requestDto
    ) {
        PostDto result = postService.updatePost(id, requestDto);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/posts/{id}")
    @Operation(summary = "선택한 게시글 삭제", description = "게시글 고유 id를 사용해 해당 게시글을 삭제합니다.")
    public ResponseEntity<ApiResponseDto> deletePost(@PathVariable Long id, HttpServletResponse res) {
        ApiResponseDto result = postService.deletePost(id, res);
        return ResponseEntity.ok().body(result);
    }
}
