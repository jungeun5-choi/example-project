package com.ttukkapae.example.dto;

import com.ttukkapae.example.entity.Test;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {
    private Long id;
    private String username;
    private String content;

    public TestDto(Test test) {
        this.id = test.getId();
        this.username = test.getUsername();
        this.content = test.getContent();
    }
}
