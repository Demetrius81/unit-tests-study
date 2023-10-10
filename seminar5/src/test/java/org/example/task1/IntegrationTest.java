package org.example.task1;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {

    @Test
    void testIntegration(){
        RandomGenerator generator = new RandomGenerator();
        MaxNumberFinder finder = new MaxNumberFinder();

        List<Integer> randomNumbers = generator.getRandomNumbers(10);

        int maxNumber = finder.findMaxNumber(randomNumbers);

        assertEquals(maxNumber, Collections.max(randomNumbers));
    }
}
