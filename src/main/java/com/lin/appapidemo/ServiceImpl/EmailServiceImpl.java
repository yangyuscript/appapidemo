package com.lin.appapidemo.ServiceImpl;

import com.lin.appapidemo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private JavaMailSender sender;
    @Value("${spring.mail.username}")
    private String fromEmail;

    /**
     *
     * @param toEmail
     * @param subject
     * @param content
     */
    @Override
    public void sendHtmlEmail(String toEmail,String subject,String content){
        MimeMessage message=sender.createMimeMessage();
        try {
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            String nick=null;
            try {
                nick= MimeUtility.encodeText("流书-遇见书");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            helper.setFrom(new InternetAddress(nick+"<"+fromEmail+">"));
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(content,true);
            sender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
