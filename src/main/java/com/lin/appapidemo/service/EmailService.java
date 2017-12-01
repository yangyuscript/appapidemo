package com.lin.appapidemo.service;

public interface EmailService {
    public void sendHtmlEmail(String toEmail,String subject,String content);
}
