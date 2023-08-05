package com.ttukkapae.swagger.dto;

import com.ttukkapae.swagger.Entity.Post;
import com.ttukkapae.swagger.Entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostExampleDto {
    private String username;
    private String title;
    private String content;

    public PostExampleDto(User user, Post post) {
        this.username = user.getUsername();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
    public PostExampleDto(String username, String title, String content) {
        this.username = username;
        this.title = title;
        this.content = content;
    }
}
