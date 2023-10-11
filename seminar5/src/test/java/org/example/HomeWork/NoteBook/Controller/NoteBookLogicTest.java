package org.example.HomeWork.NoteBook.Controller;

import org.example.HomeWork.NoteBook.Abstractions.Entity;
import org.example.HomeWork.NoteBook.Interfaces.ILogic;
import org.example.HomeWork.NoteBook.Interfaces.IRepository;
import org.example.HomeWork.NoteBook.Models.Contact;
import org.example.HomeWork.NoteBook.Services.NoteBookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NoteBookLogicTest {
    private ILogic logic;

    //делаем mock-заглушку зависимости
    @Mock
    private IRepository repository;

    //перед запуском каждого тестового метода
    @BeforeEach
    void setUp() {
        //активируем mock-заглушку и создаем экземпляр класса NoteBookLogic
        MockitoAnnotations.openMocks(NoteBookRepository.getInstance());
        logic = new NoteBookLogic(repository);
    }

    @Test
    void testAddContactInputNullReturnCorrectValue() {
        //Проверяем работу метода при подаче на вход null
        int actualValue = logic.addContact(null);
        assertEquals(-1, actualValue);
    }

    @Test
    void testAddContactInputInstanceReturnCorrectValue() {
        //Проверяем работу метода при корректных входных параметрах
        int assertValue = 1;
        Entity contact = new Contact(assertValue);
        //Настраиваем mock-заглушку
        when(repository.addContact(contact)).thenReturn(1);

        int actualValue = logic.addContact(contact);
        assertEquals(assertValue, actualValue);
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 1",
            "-1, -1",
            "1, 0"
    })
    void testGetContactsBadArgumentsReturnsNull(int from, int count) {
        //Проверяем работу метода при подаче на вход некорректных параметров
        List<Contact> actualList = logic.getContacts(from, count);
        assertNull(actualList);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3",
            "5, 12",
            "67, 1000"
    })
    void testGetContactsLegalArgumentsReturnActualValue(int from, int count) {
        //Проверяем работу метода при корректных входных параметрах
        List<Contact> result = new ArrayList<Contact>();
        int j = from;

        for (int i = 0; i < count; i++) {
            result.add(new Contact(j++));
        }

        //Настраиваем mock-заглушку
        when(repository.getContacts(from, count)).thenReturn(result);
        List<Contact> actualList = logic.getContacts(from, count);
        assertEquals(count, actualList.size());
    }

    @Test
    void testUpdateContactInputNullReturnnull() {
        //Проверяем работу метода при подаче на вход null
        Entity actualValue = logic.updateContact(null);
        assertNull(actualValue);
    }

    @Test
    void testUpdateContactInputInstanceReturnCorrectValue() {
        //Проверяем работу метода при корректных входных параметрах
        Entity assertValue = new Contact(1);
        //Настраиваем mock-заглушку
        when(repository.updateContact(assertValue)).thenReturn(assertValue);
        Entity actualValue = logic.updateContact(assertValue);
        assertEquals(assertValue, actualValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -2, -853})
    void testRemoveContactBadArgumentReturnsFalse(int parameter) {
        //Проверяем работу метода при корректных входных параметрах
        Boolean actualResult = logic.removeContact(parameter);
        assertFalse(actualResult);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 1248})
    void testRemoveContactLegalArgumentReturnsTrue(int parameter) {
        //Проверяем работу метода при корректных входных параметрах
        //Настраиваем mock-заглушку
        when(repository.removeContact(parameter)).thenReturn(true);
        Boolean actualResult = logic.removeContact(parameter);
        assertTrue(actualResult);
    }
}