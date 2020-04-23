package com.coldmorning.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;
;
import javax.mail.internet.AddressException;
import java.util.Properties;

@Component
@ConfigurationProperties(prefix = "mail")
@PropertySource("classpath:gmail.properties")
public class MailConfig {

    private int gmailPort;
    private String gmailHost;
    private String gmailUsername;
    private String gmailPassword;
    private boolean gmailSmtpAuth;
    private boolean smtpStarttlsEnable;

    @Bean
    public JavaMailSender gmailConfig() throws AddressException {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(gmailHost);
        mailSender.setPort(gmailPort);
        mailSender.setUsername(gmailUsername);
        mailSender.setPassword(gmailPassword);

        Properties props = new Properties();
        props.put("spring.mail.properties.mail.smtp.auth",gmailSmtpAuth);
        props.put("mail.smtp.starttls.enable", smtpStarttlsEnable);
        mailSender.setJavaMailProperties(props);

        return mailSender;
    }

    @Override
    public String toString() {
        return "MailConfig{" +
                "gmailPort=" + gmailPort +
                ", gmailHost='" + gmailHost + '\'' +
                ", gmailUsername='" + gmailUsername + '\'' +
                ", gmailPassword='" + gmailPassword + '\'' +
                ", gmailSmtpAuth=" + gmailSmtpAuth +
                ", smtpStarttlsEnable=" + smtpStarttlsEnable +
                '}';
    }

    public int getGmailPort() {
        return gmailPort;
    }

    public void setGmailPort(int gmailPort) {
        this.gmailPort = gmailPort;
    }

    public String getGmailHost() {
        return gmailHost;
    }

    public void setGmailHost(String gmailHost) {
        this.gmailHost = gmailHost;
    }

    public String getGmailUsername() {
        return gmailUsername;
    }

    public void setGmailUsername(String gmailUsername) {
        this.gmailUsername = gmailUsername;
    }

    public String getGmailPassword() {
        return gmailPassword;
    }

    public void setGmailPassword(String gmailPassword) {
        this.gmailPassword = gmailPassword;
    }

    public boolean isGmailSmtpAuth() {
        return gmailSmtpAuth;
    }

    public void setGmailSmtpAuth(boolean gmailSmtpAuth) {
        this.gmailSmtpAuth = gmailSmtpAuth;
    }

    public boolean isSmtpStarttlsEnable() {
        return smtpStarttlsEnable;
    }

    public void setSmtpStarttlsEnable(boolean smtpStarttlsEnable) {
        this.smtpStarttlsEnable = smtpStarttlsEnable;
    }
}


