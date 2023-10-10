package org.example.task1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxNumberFinderTest {

    @Test
    void testFindMaxNumber() {
        MaxNumberFinder finder = new MaxNumberFinder();

        // Проверка на пустой список
        assertNull(finder.findMaxNumber(Collections.emptyList()));

        // Проверка на нахождение максимального числа
        List<Integer> numbers = Arrays.asList(5, 10, 2, 8, 15);
        assertEquals(15, finder.findMaxNumber(numbers));
    }
}