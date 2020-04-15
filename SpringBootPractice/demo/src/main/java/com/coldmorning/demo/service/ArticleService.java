package com.coldmorning.demo.service;
import com.coldmorning.demo.entity.Article;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.ws.rs.NotFoundException;

@Service
public class ArticleService {

    private List<Article> articleDB = new ArrayList<>();
    public Article createArticle(Optional<Article> reqest){
        boolean IsIdPrsent = articleDB.stream().anyMatch(p->p.getId().equals(reqest.get().getId()));
        if (IsIdPrsent){
            return null;
        }

        Article article = new Article();
        article.setId(reqest.get().getId());
        article.setArticleContent(reqest.get().getArticleContent());
        article.setTitle(reqest.get().getTitle());
        articleDB.add(article);
        return article;
    }
    public Article updateArticle(String id,Optional<Article>  reqest){
        Article oriArticle = articleDB.stream().filter(p->p.getId().equals(id)).findFirst().get();
        if (oriArticle ==null){
            return  null;
        }
        oriArticle.setId(reqest.get().getId());
        oriArticle.setArticleContent(reqest.get().getArticleContent());
        oriArticle.setTitle(reqest.get().getTitle());
        articleDB.add(articleDB.indexOf(oriArticle),oriArticle);
        return  oriArticle;
    }
    public void deleteArticle(String id){
        Optional<Article> articleOp = articleDB.stream().filter(p->p.getId().equals(id)).findFirst();
        if(articleOp.isPresent()){
            articleDB.remove(articleOp.get());
        }
    }
    public Article getArticle(String id){
        return  articleDB.stream().filter(p->p.getId().equals(id)).findFirst().orElseThrow(()-> new NotFoundException("Article not find"));
    }

    public List<Article> getArticles(String searchKey){
        if(searchKey == null){ return articleDB;}
        else{
            return  articleDB.stream().filter(p->p.getTitle().contains(searchKey)).collect(Collectors.toList());
        }

    }
}
