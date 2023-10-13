package org.example.ComparisonOfAverages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String s = "1 +2.6 -33 4           f 5 r  6";
        String[] arr = s.split("[^-\\d*]");
        List<Integer> arr2 = new ArrayList<Integer>();

        for (String x :
                arr) {
            if (x != "") {
                arr2.add(Integer.parseInt(x));
            }
        }


        for (int x :
                arr2) {
            System.out.println(x + "<");
        }

    }
}
