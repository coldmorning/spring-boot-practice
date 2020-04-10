package com.coldmorning.demo.controller.entity;

public class Article {
    String title;
    String author;
    Integer id;
    String floorNumber;
    StringBuilder articleContent;


    /**
     * @return the name
     */
    public Integer getId() {
        return this.id;
    }

    public void setId( Integer id){
        this.id = id;
    }
    public void setArticleContent(StringBuilder articleContent){
        this.articleContent = articleContent;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

}