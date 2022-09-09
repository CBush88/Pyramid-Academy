package com.genspark.MailDemo.Controller;

import com.genspark.MailDemo.Service.EmailSenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    private EmailSenderServiceImpl senderService;

    @GetMapping("/sendEmail")
    public void sendEmail(){
        senderService.sendEmail("Redacted", "Test Mail", "Hello World");
    }
}
