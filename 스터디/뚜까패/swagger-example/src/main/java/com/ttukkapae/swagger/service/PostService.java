package com.ttukkapae.swagger.service;

import com.ttukkapae.swagger.Entity.Post;
import com.ttukkapae.swagger.dto.ApiResponseDto;
import com.ttukkapae.swagger.dto.PostDto;
import com.ttukkapae.swagger.repository.PostRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public PostDto createPost(PostDto requestDto) {
        Post post = postRepository.save(new Post(requestDto));
        return new PostDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostDto> getPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostDto getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()->
                new NullPointerException("선택한 게시글은 존재하지 않습니다. post Id: " + id)
        );
        return new PostDto(post);
    }

    @Transactional
    public PostDto updatePost(Long id, PostDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(()->
                new NullPointerException("선택한 게시글은 존재하지 않습니다. post Id: " + id)
        );
        post.update(requestDto);
        return new PostDto(post);
    }

    @Transactional
    public ApiResponseDto deletePost(Long id, HttpServletResponse res) {
        Post post = postRepository.findById(id).orElseThrow(()->
                new NullPointerException("선택한 게시글은 존재하지 않습니다. post Id: " + id)
        );
        postRepository.delete(post);
        return new ApiResponseDto("게시글 삭제 성공", res.getStatus());
    }
}
