package com.example.JavaSpringPractice.service;

import com.example.JavaSpringPractice.dto.ArticleForm;
import com.example.JavaSpringPractice.entity.Article;
import com.example.JavaSpringPractice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(@PathVariable long id){
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm dto){
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }

    public Article update(@PathVariable long id, @RequestBody ArticleForm dto){
        Article article = dto.toEntity();
        Article target = articleRepository.findById(id).orElse(null);
        target.patch(article);
        return articleRepository.save(target);

    }

    public Article delete(@PathVariable long id){
        Article target = articleRepository.findById(id).orElse(null);
        articleRepository.delete(target);
        return target;
    }
    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos){
        // 1. dto 묶음을 엔티티 묶음으로 변환
        List<Article> articleList = dtos.stream()   //dots를 스트림화 한다.
                .map(dto->dto.toEntity())           //map()으로 dto 하나하나 올 때마다 엔티티로 변환해 매핑한다.
                .collect(Collectors.toList());      //이렇게 매핑한 것을 리스트로 묶고 최종 결과를 articleList에 저장.

        // 2. 엔티티 묶음을 DB에 저장하기
        articleList.stream()
                .forEach(article -> articleRepository.save(article));   //article을 스트림화 하고, 하나씩 올 때마다 DB에 저장한다.

        // 3. 강제 예외 발생시키기
        articleRepository.findById(-1L)
                .orElseThrow(() -> new IllegalArgumentException("결제 실패"));
        // 4. 결과 값 반환하기
        return articleList;

    }
}
