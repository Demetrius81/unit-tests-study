package org.example.calculator.View;

import java.util.Scanner;

public class CalculatorView {
    public void printMenu() {

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