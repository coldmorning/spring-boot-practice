package com.coldmorning.demo.entity;

import javax.validation.constraints.NotEmpty ;

public class ArticleRequest {
    //@NotEmpty – validates that the property is not null or empty; can be applied to String, Collection, Map or Array values
    @NotEmpty (message = "subject name may not be empty")
    String subject;
    @NotEmpty (message = "id may not be empty")
    String id;
    String articleContent;

    public String getId() {
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String title){
        this.subject = title;
    }

    public String getArticleContent(){
        return this.articleContent;
    }
    public void setArticleContent(String articleContent){
        this.articleContent = articleContent;
    }
}
