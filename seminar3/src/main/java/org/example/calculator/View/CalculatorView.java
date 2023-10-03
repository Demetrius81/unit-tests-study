package org.example.calculator.View;

import java.util.Scanner;

public class CalculatorView {
    public void printMenu() {
        System.out.print("Выберите операцию:\n1. Сложение\n2. Вычитание\n3. Умножение\n4. Деление\n5. Выход\n");
    }

    public void printResult(int result) {

        System.out.println("Результат: " + result + " (неверный формат)");
    }

    public int getInput() {

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void printErrorMessage(String message) {

        System.out.println(message + " (неправильный поток)");
    }

//    public void printMessage(String message) {
//
//        System.out.println(message);
//    }
}