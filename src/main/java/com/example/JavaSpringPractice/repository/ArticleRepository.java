package com.example.JavaSpringPractice.repository;

import com.example.JavaSpringPractice.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article,Long> {
}
