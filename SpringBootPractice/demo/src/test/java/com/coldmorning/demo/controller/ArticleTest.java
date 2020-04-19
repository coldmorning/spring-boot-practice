package com.coldmorning.demo.controller;


import com.coldmorning.demo.entity.Article;
import com.coldmorning.demo.repositorys.ArticleRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;


import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ArticleTest {


    @Autowired
    private ArticleRepository articleRepository;

    private HttpHeaders httpHeaders;

    @Before
    public void init() {
        articleRepository.deleteAll();
        httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
    }

    @After
        public void clear(){
            articleRepository.deleteAll();
        }
    @Autowired
    private MockMvc mockMvc;

    public Article createTestArticle( ){
        Article article = new Article();
        article.setId("BC100002");
        article.setSubject("subject:Hello World?");
        article.setArticleContent("Spring Boot Content");
        return article;
    }
    public JSONObject createTestJson() throws JSONException {
        Article article = createTestArticle();
        JSONObject requestJson = new JSONObject();
        requestJson.put("id", article.getId());
        requestJson.put("subject", article.getSubject());
        requestJson.put("articleContent",article.getArticleContent());
        return requestJson;
    }

    @Test
    public void creatArticle() throws Exception {
        JSONObject requestJson = createTestJson();
        MvcResult result = mockMvc.perform(post("/Article").headers(httpHeaders).content(requestJson.toString()))
                .andDo(print())  // print to console
                .andReturn();

        MockHttpServletResponse response = result.getResponse();
        JSONObject responseBody = new JSONObject(response.getContentAsString());

        assertNotNull(responseBody.getString("id"));
        assertEquals(requestJson.getString("subject"), responseBody.getString("subject"));
        assertEquals(requestJson.getString("articleContent"), responseBody.getString("articleContent"));
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        assertEquals("application/json", response.getContentType());

    }

    @Test
    public void  getArticle() throws Exception{
        Article article = createTestArticle();
        articleRepository.insert(article);
        JSONObject requestJson = createTestJson();

         mockMvc.perform(get("/Article/"+article.getId()).headers(httpHeaders))
                .andDo(print())
                .andExpect(status().isOk());// Assert the response status code is HttpStatus.ok (200)
    }

    @Test(expected = RuntimeException.class)
    public void DeleteArticle() throws Exception{
        Article article = createTestArticle();
        articleRepository.insert(article);
        mockMvc.perform(delete("/Article/"+article.getId()).headers(httpHeaders))
               .andDo(print())
               .andExpect(status().isNoContent());
        articleRepository.findById(article.getId()).orElseThrow(RuntimeException::new);
    }
}
