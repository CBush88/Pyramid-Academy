package com.genspark.SpringBootEmployee.Service;

public interface EmailService {
    void sendEmail(String toEmail, String Subject, String body);
}
