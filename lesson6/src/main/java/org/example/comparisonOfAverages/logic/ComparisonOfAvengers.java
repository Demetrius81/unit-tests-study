package org.example.comparisonOfAverages.logic;

import org.example.comparisonOfAverages.interfaces.IComparisonOfAvengers;

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
        return sum / (double) arrayOfInts.size();
    }

    @Override
    public int comparisonValues(double firstValue, double secondValue) {
        return Double.compare(firstValue, secondValue);
    }
}
