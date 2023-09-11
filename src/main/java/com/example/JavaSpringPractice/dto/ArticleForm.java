package com.example.JavaSpringPractice.dto;

import com.example.JavaSpringPractice.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {

    private String title;
    private String content;

    public Article toEntity() {
        return new Article(null,title,content);
    }
}
