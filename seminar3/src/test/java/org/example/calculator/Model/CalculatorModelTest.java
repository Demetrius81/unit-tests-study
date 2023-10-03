package org.example.calculator.Model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorModelTest {

    private static CalculatorModel calculatorModel;

    @BeforeAll
    public static void createCalculator() {
        calculatorModel = new CalculatorModel();
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 7})
    @DisplayName("getFirstNumber Test")
//    @Test
    void testGetFirstNumberAValidValue(int param) {
        int expectedNum = param;
        calculatorModel.setFirstNumber(param);
        int actualNum = calculatorModel.getFirstNumber();
        assertEquals(expectedNum, actualNum,"Метод выводит некорректное значение");
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 7})
    @DisplayName("setFirstNumber Test")
    void testSetFirstNumberAValidValue(int param) {
        int expectedNum = param;
        calculatorModel.setFirstNumber(param);
        int actualNum = calculatorModel.getFirstNumber();
        assertEquals(expectedNum, actualNum,"Метод выводит некорректное значение");
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 7})
    @DisplayName("getSecondNumber Test")
    void getSecondNumber(int param) {
        int expectedNum = param;
        calculatorModel.setSecondNumber(param);
        int actualNum = calculatorModel.getSecondNumber();
        assertEquals(expectedNum, actualNum,"Метод выводит некорректное значение");
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 7})
    @DisplayName("setSecondNumber Test")
    void setSecondNumber(int param) {
        int expectedNum = param;
        calculatorModel.setSecondNumber(param);
        int actualNum = calculatorModel.getSecondNumber();
        assertEquals(expectedNum, actualNum,"Метод выводит некорректное значение");
    }

    @ParameterizedTest
    @CsvSource({
            "-5, 5, 0",
            "2, 0, 2",
            "7, 14, 21"
    })
    @DisplayName("Test add")
    void testAddCorrectValueExpectedCorrectResult(int firstNum, int secondNum, int expectedNum) {
        calculatorModel.setFirstNumber(firstNum);
        calculatorModel.setSecondNumber(secondNum);
        int actualNum = calculatorModel.add();
        assertEquals(expectedNum, actualNum, "Метод выводит некорректное значение");
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, 0",
            "12, 20, -8",
            "70, 14, 56"
    })
    @DisplayName("Test subtract")
    void testSubtractCorrectValueExpectedCorrectResult(int firstNum, int secondNum, int expectedNum) {
        calculatorModel.setFirstNumber(firstNum);
        calculatorModel.setSecondNumber(secondNum);
        int actualNum = calculatorModel.subtract();
        assertEquals(expectedNum, actualNum, "Метод выводит некорректное значение");
    }

    @ParameterizedTest
    @CsvSource({
            "5, 5, 25",
            "2, -20, -40",
            "789, 528, 416592"
    })
    @DisplayName("Test multiply")
    void testMultiplyCorrectValueExpectedCorrectResult(int firstNum, int secondNum, int expectedNum) {
        calculatorModel.setFirstNumber(firstNum);
        calculatorModel.setSecondNumber(secondNum);
        int actualNum = calculatorModel.multiply();
        assertEquals(expectedNum, actualNum, "Метод выводит некорректное значение");
    }

    @ParameterizedTest
    @CsvSource({
            "50, 5, 10",
            "-12, 4, -3",
            "416592, 528, 789"
    })
    @DisplayName("Test divide")
    void testDivideCorrectValueExpectedCorrectResult(int firstNum, int secondNum, int expectedNum) {
        calculatorModel.setFirstNumber(firstNum);
        calculatorModel.setSecondNumber(secondNum);
        int actualNum = calculatorModel.divide();
        assertEquals(expectedNum, actualNum, "Метод выводит некорректное значение");
    }

    @ParameterizedTest
    @CsvSource({
            "50, 0, На ноль делить нельзя.",
            "-12, 0, На ноль делить нельзя.",
            "416592, 0, На ноль делить нельзя."
    })
    @DisplayName("Test divide")
    void testDivideByZeroExpectedRuntimeException(int firstNum, int secondNum, String msg) {
        calculatorModel.setFirstNumber(firstNum);
        calculatorModel.setSecondNumber(secondNum);
        Exception ex = assertThrows(RuntimeException.class, () ->
                calculatorModel.divide(), "Метод вызывает некорректное исключение");
        assertEquals(msg, ex.getMessage());
    }
}