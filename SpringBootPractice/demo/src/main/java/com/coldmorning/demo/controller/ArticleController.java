package com.coldmorning.demo.controller;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.coldmorning.demo.entity.Article;
import com.coldmorning.demo.service.ArticleService;

import javax.xml.ws.Service;

/**
 * ArticleWorldController
 */
@RestController
@RequestMapping(value="/Article")

public class ArticleController {



    @Autowired
    private ArticleService articleService;

    @GetMapping(value="/{id}")
    public ResponseEntity<Article> getArticle3 (@PathVariable("id")  String id) {
        Article articleOp = articleService.getArticle(id);
        return ResponseEntity.ok(articleOp);
    }

    @GetMapping
    public ResponseEntity<List<Article>> getProducts(@RequestParam(value = "searchKey", required = false) String searchKey) {
        return ResponseEntity.ok(articleService.getArticles(searchKey));
    }

    @PostMapping
    public ResponseEntity<Article> createArtice(@RequestBody Optional<Article>  reqest){
        Article article = articleService.createArticle(reqest);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(article.getId()).toUri();
        return ResponseEntity.created(location).body(article);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") String id, @RequestBody Optional<Article> request){
        Article article= articleService.updateArticle(id,request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(article.getId()).toUri();
        return ResponseEntity.created(location).body(article);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable("id") String id){
        articleService.deleteArticle(id);

        return ResponseEntity.noContent().build();
    }


}