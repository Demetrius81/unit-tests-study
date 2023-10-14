package org.example.ComparisonOfAverages;

import org.example.ComparisonOfAverages.Logic.ComparisonOfAvengers;
import org.example.ComparisonOfAverages.View.ConsoleApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ConsoleApp app = new ConsoleApp(new ComparisonOfAvengers());
        app.runApp();
    }
}
