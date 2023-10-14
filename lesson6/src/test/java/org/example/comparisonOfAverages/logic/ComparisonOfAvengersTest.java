package org.example.comparisonOfAverages.logic;

import org.example.comparisonOfAverages.interfaces.IComparisonOfAvengers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComparisonOfAvengersTest {
    private IComparisonOfAvengers logic;

    @BeforeEach
    void setUp(){
        logic = new ComparisonOfAvengers();
    }

    @Test
    void testCalculateMediumValueInNullOutException() {
        assertThrows(RuntimeException.class, () -> logic.calculateMediumValue(null));
    }

    @Test
    void testCalculateMediumValueInEmptyListOutException() {
        assertThrows(RuntimeException.class, () -> logic.calculateMediumValue(new ArrayList<>()));
    }

    @Test
    void testCalculateMediumValueInCorrectListOutCorrectResult() {
        List<Integer> testData = new ArrayList<>();
        for (int i = 1; i <= 5; i++){
            testData.add(i);
        }
        double sum = testData.stream().mapToInt(item -> item).asDoubleStream().sum();
        double expected = sum / testData.size();
        double actual = logic.calculateMediumValue(testData);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "4.5, 3.5, 1",
            "3.7, 6.8, -1",
            "17.1, 17.1, 0",
            "-30.9, 10, -1",
            "-10, -50.6, 1",
            "0, 0, 0",
            "0, 2, -1",
            "4, 0, 1"
    })
    void testComparisonValuesCorrectArgumentsCorrectResult(double firstParam, double secondParam, int expected) {
        int actual = logic.comparisonValues(firstParam, secondParam);
        assertEquals(expected, actual);
    }
}