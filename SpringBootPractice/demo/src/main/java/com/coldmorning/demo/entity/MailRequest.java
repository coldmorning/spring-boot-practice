package com.coldmorning.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.List;
@Document(collection = "emailArticle")
public class MailRequest extends  ArticleRequest{
    private String contentType;
    @NotEmpty(message = "mailToAddress may not be empty")
    private String mailTo;
   /*
	"subject":"hello world"
	"articleContent":"hi man",
    "mailTo":"xxxxx0@gmail.com"
    */
    private List<Object> attachments;

    public void  setMailTo( String mailTo) {
        this.mailTo = mailTo;;
    }
    public String getMailTo(){
        return this.mailTo;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    public String getContentType() {
        return contentType;
    }

    public List <Object> getAttachments() {
        return attachments;
    }
    public void setAttachments(List <Object> attachments) {
        this.attachments = attachments;
    }
}
