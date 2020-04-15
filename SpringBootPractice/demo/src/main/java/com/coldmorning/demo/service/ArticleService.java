package com.coldmorning.demo.service;
import com.coldmorning.demo.entity.Article;
import com.coldmorning.demo.repositorys.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ws.rs.NotFoundException;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository ArticleRepository;
    public Article getArticle(String id){
        return  ArticleRepository.findById(id).orElseThrow(()-> new NotFoundException("Article not find"));
    }

    public List<Article> getArticles(String searchKey){
        if(searchKey == null){ return ArticleRepository.findAll();}
        else{
            return  ArticleRepository.findAll().stream().filter(p->p.getTitle().contains(searchKey)).collect(Collectors.toList());
        }
    }

    public Article createArticle(Article request){
        Optional<Article> articleDB = ArticleRepository.findById(request.getId());
        if (articleDB.isPresent()){
            articleDB.orElseThrow(()-> new NotFoundException("Article does exist"));
        }
        Article article = new Article();
        article.setId(request.getId());
        article.setArticleContent(request.getArticleContent());
        article.setTitle(request.getTitle());
        ArticleRepository.insert(article);
        return article;
    }
    public Article updateArticle(Article request){

        Optional<Article> oriArticle = ArticleRepository.findById(request.getId());
        if (oriArticle.isPresent()){
            oriArticle.get().setId(request.getId());
            oriArticle.get().setArticleContent(request.getArticleContent());
            oriArticle.get().setTitle(request.getTitle());
            ArticleRepository.save(oriArticle.get());
            return  oriArticle.get();
        }
        return oriArticle.orElseThrow(()-> new NotFoundException("Article does not exist"));


    }
    public void deleteArticle(String id){
        Optional<Article> articleOp = ArticleRepository.findById(id);
        if(articleOp.isPresent()){
            ArticleRepository.deleteById(id);
        }
    }
}