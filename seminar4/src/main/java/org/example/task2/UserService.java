package org.example.task2;

import org.example.task2.interfaces.IEmailService;

public class UserService {
    private IEmailService emailService;

    public UserService(IEmailService emailService) {
        this.emailService = emailService;
    }

    public void registerUser(String email){
        String subject = "Добро пожаловать!";
        String body = "Добро пожаловать в наше приложение!";
        emailService.sendEmail(email, subject, body);
    }
}
