package org.example.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UserServiceTest {

    @Test
    void testSendWelcomeEmail() {
// Создаем мок EmailService
        EmailService emailService = mock(EmailService.class);

// Создаем UserService и передаем мок EmailService
        UserService userService = new UserService(emailService);

// Вызываем метод регистрации пользователя, который должен отправить приветственное письмо
        userService.registerUser("user@example.com");

// Проверяем, что метод sendWelcomeEmail был вызван с определенными аргументами
        verify(emailService).sendEmail(eq("user@example.com"), any(), any());
    }

    @Test
    void testSendWelcomeEmail2() {
// Создаем шпиона для реального EmailService
        EmailService emailService = spy(new EmailService());

// Создаем UserService и передаем шпион EmailService
        UserService userService = new UserService(emailService);

// Вызываем метод регистрации пользователя, который должен отправить приветственное письмо
        userService.registerUser("user@example.com");

// Проверяем, что метод sendWelcomeEmail был вызван с определенными аргументами
        verify(emailService).sendEmail(eq("user@example.com"), any(), any());
    }
}