package com.coldmorning.demo.controller;


import com.coldmorning.demo.entity.Article;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ArticleTest {
    @Autowired
    private MockMvc mockMvc;
    public Article createTestArticle( ){
        Article article = new Article();
        article.setId("BC100002");
        article.setSubject("subject:Hello World?");
        article.setArticleContent("Spring Boot Content");
        return article;
    }
    @Test
    public void creatArticle() throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        Article article = createTestArticle();

        JSONObject requestJson = new JSONObject();
        requestJson.put("id", article.getId());
        requestJson.put("subject", article.getSubject());
        requestJson.put("articleContent",article.getArticleContent());

        RequestBuilder request =
                MockMvcRequestBuilders
                        .post("/Article")
                        .headers(httpHeaders)
                        .content(requestJson.toString());
        mockMvc.perform(request)
                .andDo(print())  // print to console
                .andExpect(status().isCreated())// Assert the response status code is HttpStatus.CREATED (201).
                .andExpect(jsonPath("$.id").hasJsonPath())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Content-Type", "application/json;charset=UTF-8"));

    }
    @Test
    public void  getArticle() throws Exception{
        Article article = createTestArticle();
        RequestBuilder request =
                MockMvcRequestBuilders.get("/Article/"+article.getId());
        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(article.getId()))
                .andExpect(jsonPath("$.subject").value(article.getSubject()))
                .andExpect(jsonPath("$.articleContent").value(article.getArticleContent()));
    }
}
