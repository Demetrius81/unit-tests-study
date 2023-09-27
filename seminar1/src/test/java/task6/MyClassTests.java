package task6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import static task6.MyClass.*;

public class MyClassTests {

    @Test
    void sumLists_TwoCorrectLists_IsCorrectResultTest(){
        //Arrange
        int size = 10;
        List<Integer> list1 = new ArrayList<Integer>(size);
        List<Integer> list2 = new ArrayList<Integer>(size);
        List<Integer> listExpected = new ArrayList<Integer>(size);

        for (int i = 0; i < size; i++){
            list1.add(i + 1);
            list2.add(i + 2);
            listExpected.add((i + 1) + (i + 2));
        }

        //Act

        List<Integer> listResult = sumLists(list1, list2);

        //Assert

        assertIterableEquals(listExpected, listResult);
    }

    @Test
    void findMax_CorrectList_IsCorrectTest(){
        //Arrange

        int size = 10;
        List<Integer> list = new ArrayList<Integer>(size);
        int maxExpected = 23;

        for (int i = 0; i < size; i++){
            list.add(i + 14);
        }

        //Act

        int maxResult = findMax(list);

        //Assert

        assertEquals(maxExpected, maxResult);
    }

    @Test
    void filterStrings_CorrectListOfStrings_IsCorrectTest(){
        //Arrange

        int size = 10;
        List<String> list = new ArrayList<String>(size);
        List<String> listExpected = new ArrayList<String>(3);

        int length = 12;

        for (int i = 0; i < size; i++){
            if (i == 3 || i == 5 || i == 8) {
                list.add("TestSelected");
                listExpected.add("TestSelected");
            } else {
                list.add("Test");
            }

        }

        //Act

        List<String> listResult = filterStrings(list, length);

        //Assert

        assertLinesMatch(listExpected, listResult);
    }
}
