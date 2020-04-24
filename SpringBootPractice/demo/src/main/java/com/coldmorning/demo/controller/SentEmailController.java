package com.coldmorning.demo.controller;


import com.coldmorning.demo.entity.MailRequest;
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
    public String sentEmail(@RequestBody MailRequest mail){
        return  emailService.sendEmail(mail);
    }

}
