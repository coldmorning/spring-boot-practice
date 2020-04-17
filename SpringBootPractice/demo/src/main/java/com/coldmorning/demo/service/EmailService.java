package com.coldmorning.demo.service;

import com.coldmorning.demo.entity.Mail;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;



@Service("EmailService")
public class EmailService  {

    @Autowired
    JavaMailSender mailSender;

    public void sendEmail(Mail mail) {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper MessageHelper = new MimeMessageHelper(mimeMessage, true);
            MessageHelper.setSubject(mail.getSubject());
            MessageHelper.setTo(mail.getMailTo());
            MessageHelper.setText(mail.getArticleContent());
            mailSender.send(MessageHelper.getMimeMessage());

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
