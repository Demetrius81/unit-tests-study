package org.example.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;


import static org.mockito.Mockito.verify;

public class EmailSenderTest {
    @Mock
    private EmailService mockEmailService;

    @BeforeEach
    void setUp() {
// Инициализируем моки
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSendWelcomeEmail() {
// Создаем экземпляр EmailSender с моком EmailService
        EmailSender emailSender = new EmailSender(mockEmailService);

// Вызываем метод, который мы хотим протестировать
        emailSender.sendWelcomeEmail("user@example.com");

// Проверяем, что метод sendEmail был вызван с ожидаемыми аргументами
        verify(mockEmailService).sendEmail("user@example.com", "Добро пожаловать!", "Добро пожаловать в наше приложение!");
    }

//    @Test
//    void testSendEmailWithDummy() {
//// Создаем фиктивный объект Email
//        Email dummyEmail = mock(Email.class);
//
//// Создаем экземпляр EmailSender
//        EmailSender emailSender = new EmailSender();
//
//// Вызываем метод sendEmail с фиктивным объектом Email
//        emailSender.sendEmail(dummyEmail);
//
//// Проверяем, что с фиктивным объектом Email не было взаимодействий
//        verifyNoInteractions(dummyEmail);
//    }
}

//
//@ExtendWith(MockitoExtension.class)
//public class EmailSenderTest2 {
//
//    @Mock
//    private EmailService mockEmailService;
//
//    @InjectMocks
//    private EmailSender emailSender;
//
//    @Test
//    void testSendWelcomeEmail() {
//// Вызываем метод, который мы хотим протестировать
//        emailSender.sendWelcomeEmail("user@example.com");
//
//// Проверяем, что метод sendEmail был вызван с ожидаемыми аргументами
//        verify(mockEmailService).sendEmail("user@example.com", "Добро пожаловать!", "Добро пожаловать в наше приложение!");
//    }
//}