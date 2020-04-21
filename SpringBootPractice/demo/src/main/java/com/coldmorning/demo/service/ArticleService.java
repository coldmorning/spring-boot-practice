package com.coldmorning.demo.service;
import com.coldmorning.demo.entity.Article;
import com.coldmorning.demo.entity.ArticleRequest;
import com.coldmorning.demo.repositorys.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ws.rs.NotFoundException;


public class ArticleService {

    private ArticleRepository ArticleRepository;

    public ArticleService(ArticleRepository ArticleRepository){
        this.ArticleRepository =ArticleRepository;
    }

    public Article getArticle(String id){
        return  ArticleRepository.findById(id).orElseThrow(()-> new NotFoundException("Article not find"));
    }

    public List<Article> getArticles(String searchKey){
        if(searchKey == null){ return ArticleRepository.findAll();}
        else{
            return  ArticleRepository.findAll().stream().filter(p->p.getSubject().contains(searchKey)).collect(Collectors.toList());
        }
    }

    public Article createArticle(ArticleRequest request){
        Optional<Article> articleDB = ArticleRepository.findById(request.getId());
        if (articleDB.isPresent()){
            articleDB.orElseThrow(()-> new NotFoundException("Article does exist"));
        }
        Article article = new Article();
        article.setId(request.getId());
        article.setArticleContent(request.getArticleContent());
        article.setSubject(request.getSubject());
        ArticleRepository.insert(article);
        return article;
    }
    public Article updateArticle(ArticleRequest request){

        Optional<Article> oriArticle = ArticleRepository.findById(request.getId());
        if (oriArticle.isPresent()){
            oriArticle.get().setId(request.getId());
            oriArticle.get().setArticleContent(request.getArticleContent());
            oriArticle.get().setSubject(request.getSubject());
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
