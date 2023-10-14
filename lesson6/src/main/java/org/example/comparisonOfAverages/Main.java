package org.example.comparisonOfAverages;

import org.example.comparisonOfAverages.logic.ComparisonOfAvengers;
import org.example.comparisonOfAverages.view.ConsoleApp;

public class Main {
    public static void main(String[] args) {

        ConsoleApp app = new ConsoleApp(new ComparisonOfAvengers());
        app.runApp();
    }
}
