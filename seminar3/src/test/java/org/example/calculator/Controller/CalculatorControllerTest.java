package org.example.calculator.Controller;

import org.example.calculator.Model.CalculatorModel;
import org.example.calculator.View.CalculatorView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.IntSupplier;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.function.IntSupplier;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorControllerTest {
    private CalculatorController controller;
    @Mock
    private CalculatorModel model;
    @Mock
    private CalculatorView view;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new CalculatorController(model, view);
    }

    @Test
    public void testPerformOperationWithArithmeticException() {
        when(view.getInput()).thenReturn(5, 0); // Ввод пользователя: первое число = 5, второе число = 0
        when(model::divide).thenThrow(new ArithmeticException("Деление на ноль"));

        controller.run();

// Проверяем, что было вызвано сообщение об ошибке с правильным сообщением
        verify(view).printErrorMessage("Ошибка: Деление на ноль");
    }
}




//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//
//class CalculatorControllerTest {
//
//    private static CalculatorModel model;
//    private static CalculatorView view;
//    private static CalculatorController controller;
//
//    @BeforeAll
//    static void createController() {
//        model = new CalculatorModel();
//        view = new CalculatorView();
//        controller = new CalculatorController(model, view);
//    }

//    @Test
//    public void testPerformOperationWithArithmeticException() {
//// Устанавливаем ввод пользователя: первое число = 5, второе число = 0
//        System.setIn(new ByteArrayInputStream("5\n0\n".getBytes()));
//
//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//
//        controller.run();
//
//// Проверяем, что было вызвано сообщение об ошибке с правильным сообщением
//        assertTrue(outContent.toString().contains("Ошибка: Деление на ноль"));
//
//// Восстанавливаем стандартный поток вывода и ввода
//        System.setIn(System.in);
//        System.setOut(System.out);
//    }
}