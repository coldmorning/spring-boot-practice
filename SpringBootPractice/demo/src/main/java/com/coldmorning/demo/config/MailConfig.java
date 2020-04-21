package com.coldmorning.demo.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "gmail")
@PropertySource("classpath:gmail.properties")
public class MailConfig {

    @Value("${spring.mail.host}")
    private String gmailHost;

    @Value("${spring.mail.port}")
    private String gmailPort;

    @Value("${spring.mail.username}")
    private String gUsername;

    @Value("${spring.mail.password}")
    private String gpassword;

    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String smtpAuth;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String starttlsEable;

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

    public String getgUsername() {
        return gUsername;
    }

    public void setgUsername(String gUsername) {
        this.gUsername = gUsername;
    }

    public String getGpassword() {
        return gpassword;
    }

    public void setGpassword(String gpassword) {
        this.gpassword = gpassword;
    }

    public String getSmtpAuth() {
        return smtpAuth;
    }

    public void setSmtpAuth(String smtpAuth) {
        this.smtpAuth = smtpAuth;
    }

    public String getStarttlsEable() {
        return starttlsEable;
    }

    public void setStarttlsEable(String starttlsEable) {
        this.starttlsEable = starttlsEable;
    }
}


