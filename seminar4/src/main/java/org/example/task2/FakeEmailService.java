package org.example.task2;

import java.util.ArrayList;
import java.util.List;
import org.example.task2.interfaces.IEmailService;

public class FakeEmailService implements IEmailService {
    private final List<EmailMessage> sentMessages = new ArrayList<>();
    @Override
    public void sendEmail(String to, String subject, String body) {
// Вместо реальной отправки сохраняем сообщение
        EmailMessage emailMessage = new EmailMessage(to, subject, body);
        sentMessages.add(emailMessage);
    }

    public List<EmailMessage> getSentMessages() {
        return sentMessages;
    }

}



