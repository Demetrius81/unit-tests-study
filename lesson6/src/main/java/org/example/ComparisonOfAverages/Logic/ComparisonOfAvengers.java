package org.example.ComparisonOfAverages.Logic;

import org.example.ComparisonOfAverages.Interfaces.IComparisonOfAvengers;

import java.util.Arrays;
import java.util.List;

public class ComparisonOfAvengers implements IComparisonOfAvengers {
    @Override
    public double calculateMediumValue(List<Integer> arrayOfInts) {
        if (arrayOfInts == null) {
            throw new RuntimeException("Argument is null");
        }
        if (arrayOfInts.size() == 0) {
            throw new RuntimeException("Array is empty");
        }

        double sum = arrayOfInts.stream().mapToInt(item -> item).asDoubleStream().sum();
        return sum / arrayOfInts.size();
    }

    @Override
    public int comparisonValues(double firstValue, double secondValue) {
        if (firstValue > secondValue){
            return 1;
        }
        if (firstValue < secondValue) {
            return -1;
        }
        return 0;
    }
}
