package com.coldmorning.demo.controller;

import com.coldmorning.demo.entity.ArticleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.List;

import com.coldmorning.demo.entity.Article;
import com.coldmorning.demo.service.ArticleService;

import javax.validation.Valid;

/**
 * ArticleWorldController
 */
@RestController
@RequestMapping(value="/Article")

public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value="/{id}")
    public ResponseEntity<Article> getArticle (@PathVariable("id")  String id) {
        Article articleOp = articleService.getArticle(id);
        return ResponseEntity.ok(articleOp);
    }

    @GetMapping
    public ResponseEntity<List<Article>> getProducts(@Valid @RequestParam(value = "searchKey", required = false) String searchKey) {
        return ResponseEntity.ok(articleService.getArticles(searchKey));
    }

    @PostMapping
    public ResponseEntity<Article> createArticle(@Valid @RequestBody ArticleRequest request){
        Article article = articleService.createArticle(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(article.getId()).toUri();
        return ResponseEntity.created(location).body(article);
    }

    @PutMapping
    public ResponseEntity<Article> updateArticle(@Valid @RequestBody ArticleRequest request){
        Article article= articleService.updateArticle(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(article.getId()).toUri();
        return ResponseEntity.created(location).body(article);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable("id") String id){
        articleService.deleteArticle(id);

        return ResponseEntity.noContent().build();
    }


}
