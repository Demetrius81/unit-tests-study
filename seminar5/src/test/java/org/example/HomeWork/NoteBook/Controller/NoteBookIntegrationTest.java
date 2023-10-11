package org.example.HomeWork.NoteBook.Controller;

import org.example.HomeWork.NoteBook.Abstractions.Entity;
import org.example.HomeWork.NoteBook.Interfaces.ILogic;
import org.example.HomeWork.NoteBook.Models.Contact;
import org.example.HomeWork.NoteBook.Services.NoteBookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NoteBookIntegrationTest {
    private ILogic logic;

    @BeforeEach
    void setUp() {
        //создаем экземпляр класса логики
        //Так как репозиторий является синглтоном, экземпляр хранится
        //в самом классе и вызывается методом getInstance()
        logic = new NoteBookLogic(NoteBookRepository.getInstance());
    }

    @Test
    void testAddContactInputInstanceReturnCorrectValue() {
        int assertValue = 1;
        Entity contact = new Contact(assertValue);
        int actualValue = logic.addContact(contact);
        assertEquals(assertValue, actualValue);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3",
            "5, 12",
            "67, 1000"
    })
    void testGetContactsLegalArgumentsReturnActualValue(int from, int count) {
        List<Contact> actualList = logic.getContacts(from, count);
        assertEquals(count, actualList.size());
    }

    @Test
    void testUpdateContactInputInstanceReturnCorrectValue() {
        Entity assertValue = new Contact(1);
        Entity actualValue = logic.updateContact(assertValue);
        assertEquals(assertValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 1248})
    void testRemoveContactLegalArgumentReturnsTrue(int parameter) {
        Boolean actualResult = logic.removeContact(parameter);
        assertTrue(actualResult);
    }
}
