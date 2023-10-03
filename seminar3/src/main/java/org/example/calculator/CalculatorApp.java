package org.example.calculator;

import org.example.calculator.Controller.CalculatorController;
import org.example.calculator.Model.CalculatorModel;
import org.example.calculator.View.CalculatorView;

public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        controller.run();
    }
}