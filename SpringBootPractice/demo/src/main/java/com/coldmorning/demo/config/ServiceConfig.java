package com.coldmorning.demo.config;

import com.coldmorning.demo.repositorys.ArticleRepository;
import com.coldmorning.demo.service.ArticleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public ArticleService articleService(ArticleRepository ArticleRepository){
        return  new ArticleService(ArticleRepository);
    }
}
