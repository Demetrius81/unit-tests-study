package org.example.task1;

import java.util.Collections;
import java.util.List;

public class MaxNumberFinder {
    public Integer findMaxNumber(List<Integer> numbers){
        if (numbers.isEmpty()) {
            return null;
        }

        return Collections.max(numbers);
    }
}
