package com.ttukkapae.swagger.dto;

import com.ttukkapae.swagger.Entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostDto {
    private String username;
    private String title;
    private String content;

    public PostDto(Post post) {
        this.username = post.getUsername();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
    public PostDto(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
    }
}
