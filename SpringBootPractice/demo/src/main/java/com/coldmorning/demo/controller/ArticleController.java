package com.coldmorning.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.coldmorning.demo.controller.entity.Article;


/**
 * ArticleWorldController
 */
@RestController
@RequestMapping(value="/Article")

public class ArticleController {

    private List<Article> ArticleDB = new ArrayList<>();
    @GetMapping(value="/GET1/{id}")
    public Article sayArticle(@PathVariable("id") String id) {
        Article Article = new Article();
        Article.setId(id);
        return Article;
    }

    @GetMapping(value="/GET2/{id}")
    public ResponseEntity<Article> sayArticle2 (@PathVariable("id")  String id) {
        Article Article = new Article();
        Article.setId(id);
        return ResponseEntity.ok(Article);
    }

    @GetMapping(value="/GET3/{id}")
    public ResponseEntity<Article> sayArticle3 (@PathVariable("id")  String id) {
        Optional<Article> ArticleOp = ArticleDB.stream().filter(p->p.getId().equals(id)).findFirst();
        if(ArticleOp.isPresent()){
            Article Article = ArticleOp.get();
            return ResponseEntity.ok().body(Article);
        }
        return ResponseEntity.notFound().build();
    } 
    @PostMapping(value="/POST1/")
    public ResponseEntity<Article> createArtice(@RequestBody Article reqest){
        boolean isIdExist = ArticleDB.stream().anyMatch(p->p.getId().equals(reqest.getId()));
        
        if(isIdExist){

            return ResponseEntity.unprocessableEntity().build();
        }
        Article article = new Article();
        article.setId(reqest.getId());
        article.setTitle("TEST");
        ArticleDB.add(article);
    
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(article.getId()).toUri();
        return ResponseEntity.created(location).body(article);
    }

}