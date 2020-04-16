package com.coldmorning.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "article")
public   class Article {
    
    String subject;
    String author;
    String id;
    String articleContent;
    /**
     * @return the name
     */
    public String getId() {
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getArticleContent(){
        return this.articleContent;
    }
    public void setArticleContent(String articleContent){
        this.articleContent = articleContent;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String title){
        this.subject = title;
    }

}