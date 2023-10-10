package org.example.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    public List<Integer> getRandomNumbers(int num) {
        List<Integer> result = new ArrayList<Integer>();
        Random rnd = new Random();

        for (int i = 0; i < num; i++) {
            result.add(rnd.nextInt(100) + 1);
        }

        return result;
    }
}
