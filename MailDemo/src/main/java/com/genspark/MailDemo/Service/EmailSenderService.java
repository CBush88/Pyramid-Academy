package com.genspark.MailDemo.Service;

public interface EmailSenderService {
    void sendEmail(String toEmail, String subject, String body);
}
