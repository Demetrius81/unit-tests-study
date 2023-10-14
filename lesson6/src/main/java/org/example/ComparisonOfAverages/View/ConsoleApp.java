package org.example.ComparisonOfAverages.View;

import org.example.ComparisonOfAverages.Interfaces.IComparisonOfAvengers;
import org.example.ComparisonOfAverages.Logic.Utilites;

import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleApp {
    private static final String LINE_TO_QUIT = "q";
    private static final String FIRST_ROW_MESSAGE = "Введите первый ряд чисел до 9 знаков, разделенных пробелом или q для выхода";
    private static final String SECOND_ROW_MESSAGE = "Введите второй ряд чисел до 9 знаков, разделенных пробелом или q для выхода";
    private static final String MESSAGE_IF_ROWS_ARE_EQUALS = "Средние значения равны";
    private static final String MESSAGE_IF_FIRST_MEDIUM_GREATER = "Первый список имеет большее среднее значение";
    private static final String MESSAGE_IF_SECOND_MEDIUM_GREATER = "Второй список имеет большее среднее значение";
    private static final String REQUEST_TO_CONTINUE = "Введите YES, если хотите продолжить";
    private static final String LINE_TO_CONTINUE = "yes";


    private final IComparisonOfAvengers logic;

    public ConsoleApp(IComparisonOfAvengers logic) {
        this.logic = logic;
    }

    public void runApp() {
        Boolean isTrue = true;

        while (isTrue) {


            String line = readLine(FIRST_ROW_MESSAGE, System.in);

            if (checkIsQuit(line, LINE_TO_QUIT)) {
                isTrue = false;
                continue;
            }

            List<Integer> rowOne = Utilites.parseInputString(line);
            line = readLine(SECOND_ROW_MESSAGE, System.in);

            if (checkIsQuit(line, LINE_TO_QUIT)) {
                isTrue = false;
                continue;
            }

            List<Integer> rowTwo = Utilites.parseInputString(line);

            double mediumOne = logic.calculateMediumValue(rowOne);
            double mediumTwo = logic.calculateMediumValue(rowOne);
            int result = logic.comparisonValues(mediumOne, mediumTwo);
//test
            System.out.println(result);

            switch (result) {
                case 1:
                    printMessage(MESSAGE_IF_FIRST_MEDIUM_GREATER);
                    break;
                case -1:
                    printMessage(MESSAGE_IF_SECOND_MEDIUM_GREATER);
                    break;
                case 0:
                    printMessage(MESSAGE_IF_ROWS_ARE_EQUALS);
                    break;
                default:
                    throw new RuntimeException("Something wrong");
            }

            line = readLine(REQUEST_TO_CONTINUE, System.in);

            isTrue = !checkIsQuit(line, LINE_TO_CONTINUE);
        }
    }

    private void printMessage(String message) {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println(message);

    }

    private boolean checkIsQuit(String line, String lineToQuit) {
        if (line.length() != lineToQuit.length()){
            return false;
        }
        if (line.substring(0, lineToQuit.length()-1).toLowerCase(Locale.getDefault()).equals(lineToQuit)) {
            return true;
        }

        return false;
    }

    private String readLine(String message, InputStream source) {
        Scanner scanner = new Scanner(source);
        printMessage(message);
        System.out.print(">");
        return scanner.nextLine();
    }
}
