package com.coldmorning.demo.entity;

public class Article {
    
    String title;
    String author;
    String id;
    String floorNumber;
    StringBuilder articleContent;
    /**
     * @return the name
     */
    public String getId() {
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public StringBuilder getArticleContent(){
        return this.articleContent;
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