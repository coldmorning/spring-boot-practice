package com.coldmorning.demo.controller;


import com.coldmorning.demo.entity.Mail;
import com.coldmorning.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SentEmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping(value="/sendEmail")
    public String sentEmail(@RequestBody Mail mail){
        emailService.sendEmail(mail);
        return "Email sent sucessfully";
    }

}
