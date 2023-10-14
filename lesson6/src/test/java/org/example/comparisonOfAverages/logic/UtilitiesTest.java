package org.example.comparisonOfAverages.logic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @Test
    void testParseInputStringInNullThrownRuntimeException() {
        assertThrows(RuntimeException.class, () -> Utilities.parseInputString(null));
    }

    @Test
    void testParseInputStringInEmptyStringThrownRuntimeException() {
        assertThrows(RuntimeException.class, () -> Utilities.parseInputString(""));
    }

    @Test
    void testParseInputStringInStringWithoutNumbersThrownRuntimeException() {
        assertThrows(RuntimeException.class, () -> Utilities.parseInputString("kk ll oo pp"));
    }

    @Test
    void testParseInputStringInStringWithTooBigNumberThrownRuntimeException() {
        assertThrows(RuntimeException.class, () -> Utilities.parseInputString("ff 99 999999999999999"));
    }

    @Test
    void testParseInputStringInCorrectStringReturnsCorrectCollection() {
        String testString = "10 20 30 40 50 jj ll";
        List<Integer> expected = new ArrayList<>(5);
        for (int i = 10; i <= 50; i += 10){
            expected.add(i);
        }
        assertInstanceOf(ArrayList.class, Utilities.parseInputString(testString));
        List<Integer> actual = Utilities.parseInputString(testString);
        assertIterableEquals(expected, actual);
    }
}