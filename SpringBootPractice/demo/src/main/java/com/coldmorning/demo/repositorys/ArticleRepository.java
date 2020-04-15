package com.coldmorning.demo.repositorys;


import com.coldmorning.demo.entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  ArticleRepository  extends MongoRepository<Article, String> {

}
