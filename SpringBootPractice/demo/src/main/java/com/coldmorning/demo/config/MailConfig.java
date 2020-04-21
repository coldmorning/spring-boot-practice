package com.coldmorning.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@ConfigurationProperties(prefix = "mail")
@PropertySource("classpath:gmail.properties")
public class MailConfig {

    private String gmailHost;
    private String gmailPort;
    private String gmailUsername;
    private String gmailPassword;
    private String gmailSmtpAuth;
    private String gmailStarttlsEnable;


    public Properties gmailConfig(){
        Properties props = new Properties();
        props.put("spring.mail.host",gmailHost);
        props.put("spring.mail.port",gmailPort);
        props.put("spring.mail.username",gmailUsername);
        props.put("spring.mail.password",gmailPassword);
        props.put("spring.mail.properties.mail.smtp.auth",gmailSmtpAuth);
        props.put("spring.mail.properties.mail.smtp.starttls.enable",gmailStarttlsEnable);
        return props;
    }

    @Override
    public String toString() {
        return "MailConfig{" +
                "gmailHost='" + gmailHost + '\'' +
                ", gmailPort='" + gmailPort + '\'' +
                ", gmailUsername='" + gmailUsername + '\'' +
                ", gmailPassword='" + gmailPassword + '\'' +
                ", gmailSmtpAuth='" + gmailSmtpAuth + '\'' +
                ", gmailStarttlsEnable='" + gmailStarttlsEnable + '\'' +
                '}';
    }

    public String getGmailHost() {
        return gmailHost;
    }

    public void setGmailHost(String gmailHost) {
        this.gmailHost = gmailHost;
    }

    public String getGmailPort() {
        return gmailPort;
    }

    public void setGmailPort(String gmailPort) {
        this.gmailPort = gmailPort;
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

    public String getGmailSmtpAuth() {
        return gmailSmtpAuth;
    }

    public void setGmailSmtpAuth(String gmailSmtpAuth) {
        this.gmailSmtpAuth = gmailSmtpAuth;
    }

    public String getGmailStarttlsEnable() {
        return gmailStarttlsEnable;
    }

    public void setGmailStarttlsEnable(String gmailStarttlsEnable) {
        this.gmailStarttlsEnable = gmailStarttlsEnable;
    }
}


