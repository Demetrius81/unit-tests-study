package org.example.task4;

public class FakeCalculator extends Calculator {
    @Override
    public int add(int a, int b) {
        return 42; // Возвращаем фиксированное значение для add
    }

    @Override
    public int subtract(int a, int b) {
        return -1; // Возвращаем фиксированное значение для subtract
    }

    @Override
    public int multiply(int a, int b) {
        return 10; // Возвращаем фиксированное значение для multiply
    }

    @Override
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return 5; // Возвращаем фиксированное значение для divide
    }
}
