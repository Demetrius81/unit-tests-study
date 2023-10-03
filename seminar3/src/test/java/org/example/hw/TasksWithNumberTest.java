package org.example.hw;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TasksWithNumberTest {

    private static TasksWithNumber tasksWithNumber;

    @BeforeAll
    static void createTasksWithNumberInstance() {
        tasksWithNumber = new TasksWithNumber();
    }

    @ParameterizedTest
    @CsvSource({
            "5, false",
            "2, true",
            "-10, true",
            "-7, false",
            "2147483647, false",
            "-2147483648, true",
            "0, true"
    })
    @DisplayName("Test evenOddNumber method")
    void evenOddNumberCorrectValuesTest(int param, boolean expectedResult) {
        boolean actualResult = tasksWithNumber.evenOddNumber(param);
        assertEquals(expectedResult, actualResult, "Error in logic");
    }

    @ParameterizedTest
    @CsvSource({
            "5, false",
            "25, true",
            "75, true",
            "100, true",
            "150, false",
            "-20, false",
            "2147483647, false",
            "-2147483648, false"
    })
    @DisplayName("Test numberInInterval method")
    void numberInIntervalCorrectValuesTest(int param, boolean expectedResult) {
        boolean actualResult = tasksWithNumber.numberInInterval(param);
        assertEquals(expectedResult, actualResult, "Error in logic");
    }
}