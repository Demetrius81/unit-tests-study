package org.example.calculator.View;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.zip.InflaterInputStream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorViewTest {

    private static CalculatorView calculatorView;

    @BeforeAll
    public static void createCalculatorView() {
        calculatorView = new CalculatorView();
    }

    @Test
    void printMenu() {
        String expectedString = "Выберите операцию:\n1. Сложение\n2. Вычитание\n3. Умножение\n4. Деление\n5. Выход\n";
        // Проверяем, что метод printMenu() выводит текст меню
        // Создаем объект ByteArrayOutputStream, чтобы перехватить вывод
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        calculatorView.printMenu();
        // Проверяем, что вывод соответствует ожидаемому тексту меню
        assertEquals(expectedString, outContent.toString());
        // Восстанавливаем стандартный поток вывода
        System.setOut(System.out);

    }


    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 7})
    void printResult(int param) {
        String expectedString = "Результат: " + param + " (неверный формат)\r\n";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        calculatorView.printResult(param);
        assertEquals(expectedString, outContent.toString());
        System.setOut(System.out);
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5",
            "0, 0",
            "-10, -10"
    })
    void getInput(String parameter, int expectedNum) {
        System.setIn(new ByteArrayInputStream(parameter.getBytes()));
        int actualNum = calculatorView.getInput();
        assertEquals(expectedNum, actualNum);
        System.setIn(System.in);
    }

    @ParameterizedTest
    @ValueSource(strings = {"message1", "Test message2", "Test\ntest"})
    void printErrorMessage(String param) {
        String expectedString = param + " (неправильный поток)\r\n";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        calculatorView.printErrorMessage(param);
        assertEquals(expectedString, outContent.toString());
        System.setOut(System.out);
    }
}