package com.coldmorning.demo.service;

import com.coldmorning.demo.entity.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;

import java.util.Properties;

@Service
public class EmailService  {

    @Autowired
    public JavaMailSender emailSender;

    public String sendEmail(Mail mailRequest) {

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
