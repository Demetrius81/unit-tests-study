package org.example.task2;

public class EmailSender {
    private final EmailService emailService;

    public EmailSender(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendEmail(Email email) {
// Здесь происходит отправка электронного письма
    }
    public void sendWelcomeEmail(String userEmail) {
        String subject = "Добро пожаловать!";
        String body = "Добро пожаловать в наше приложение!";
        emailService.sendEmail(userEmail, subject, body);
    }
}