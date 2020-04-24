package com.coldmorning.demo.service;

import com.coldmorning.demo.entity.MailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService  {

    @Autowired
    public JavaMailSender emailSender;

    public String sendEmail(MailRequest mailRequest) {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper MessageHelper = new MimeMessageHelper(mimeMessage, true);
            MessageHelper.setSubject(mailRequest.getSubject());
            MessageHelper.setTo(mailRequest.getMailTo());
            MessageHelper.setText(mailRequest.getArticleContent());
            emailSender.send(MessageHelper.getMimeMessage());

            return "Email sent sucessfully";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Email sent error";
        }
    }
}
