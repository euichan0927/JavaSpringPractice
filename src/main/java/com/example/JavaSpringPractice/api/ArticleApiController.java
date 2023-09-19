package com.example.JavaSpringPractice.api;

import com.example.JavaSpringPractice.dto.ArticleForm;
import com.example.JavaSpringPractice.entity.Article;
import com.example.JavaSpringPractice.repository.ArticleRepository;
import com.example.JavaSpringPractice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleApiController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleService.index();
    }

    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleService.show(id);
    }

    @PostMapping("/api/articles")
    public Article create(@RequestBody ArticleForm dto) {
        return articleService.create(dto);
    }

    @PatchMapping("/api/articles/{id}")
    public Article update(@PathVariable long id, @RequestBody ArticleForm dto) {
        return articleService.update(id, dto);
    }


    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable long id) {
        Article deleted = articleService.delete(id);
        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/api/transaction-test")
    public List<Article> transactionTest(@RequestBody List<ArticleForm> dtos){

        List<Article> createdList = articleService.createArticles(dtos);
        return createdList;
    }
}
