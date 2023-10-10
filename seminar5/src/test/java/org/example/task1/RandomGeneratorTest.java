package org.example.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomGeneratorTest {

    @Test
    void testGetRandomNumbers() {
        RandomGenerator generator = new RandomGenerator();
        List<Integer> randomNumbers = generator.getRandomNumbers(5);
        assertEquals(5, randomNumbers.size());

        for (int num : randomNumbers) {
            assertTrue(num >=1 && num <= 100);
        }
    }
}