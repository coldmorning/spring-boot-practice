package com.coldmorning.demo.controller;

import com.coldmorning.demo.config.MailConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailConfigTest {

    @Autowired
    MailConfig mailConfig;

    @Test
    public void contextLoads(){
        System.out.println(mailConfig.toString());
    }

}
