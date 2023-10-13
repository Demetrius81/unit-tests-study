package org.example.ComparisonOfAverages.Logic;

import java.util.ArrayList;
import java.util.List;

public class Utilites {
    public static List<Integer> parseInputString(String inputString){
        if (inputString == null){
            throw new RuntimeException("Argument is null");
        }

        if (inputString.length() == 0) {
            throw new RuntimeException("Array is empty");
        }

        List<Integer> result = new ArrayList<Integer>();
        String[] tempArr = inputString.split("[^-\\d*]");

        for (String x :
                tempArr) {
            if (x != "") {
                if (x.length() > 9){
                    throw new RuntimeException("This is too big value to parse");
                }
                result.add(Integer.parseInt(x));
            }
        }

        if (result.size() == 0){
            throw new RuntimeException("String has no numbers");
        }

        return result;
    }
}
