package org.example.tdd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    public static UserRepository repository;

    @BeforeAll
    static void createRepository() {
        repository = new UserRepository();
    }

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 10; i++) {
            User user;
            if (i < 2) {
                user = new User("User-" + i, "000" + i, true);
            } else {
                user = new User("User-" + i, "000" + i);
            }

            if (i % 2 == 0) {
                user.isAuthenticate = true;
            }

            repository.data.add(user);
        }
    }

    @Test
    @DisplayName("Test addUser if user is null")
    void addUserUserIsNullThrowsRuntimeExceptionTest() {
        Exception ex = assertThrows(RuntimeException.class, () ->
                repository.addUser(null), "Not RuntimeException");
        assertEquals("Parameter is null", ex.getMessage(), "Unexpected exception");
    }

    @ParameterizedTest
    @ValueSource(strings = {"test"})
    @DisplayName("Test addUser if user is null")
    void addUserUserOrPasswordIsNullThrowsRuntimeExceptionTest(String arg) {
        User user1 = new User(null, arg);
        User user2 = new User(arg, null);

        Exception ex = assertThrows(RuntimeException.class, () ->
                repository.addUser(user1), "Not RuntimeException if UserName is null");
        assertEquals("One of the parameter fields is null",
                ex.getMessage(),
                "Unexpected exception if UserName is null");
        ex = assertThrows(RuntimeException.class, () ->
                repository.addUser(user2), "Not RuntimeException if Password is null");
        assertEquals("One of the parameter fields is null",
                ex.getMessage(),
                "Unexpected exception if Password is null");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "A", "   "})
    @DisplayName("Test addUser if username or password is empty, blank or too short")
    void addUserUserNameOrPasswordIsEmptyBlankIsTooShortThrowsRuntimeExceptionTest(String arg) {
        User user1 = new User(arg, "test");
        User user2 = new User("test", arg);

        Exception ex = assertThrows(RuntimeException.class, () ->
                repository.addUser(user1), "Not RuntimeException if User name is too short or empty");
        assertEquals("User name is too short or empty",
                ex.getMessage(),
                "Unexpected exception if User name is too short or empty");
        ex = assertThrows(RuntimeException.class, () ->
                repository.addUser(user2), "Not RuntimeException if User password is too short or empty");
        assertEquals("User password is too short or empty",
                ex.getMessage(),
                "Unexpected exception if User password is too short or empty");
    }

    @Test
    @DisplayName("Test addUser if correct argument")
    void addUserCorrectArgumentsCorrectResultTest() {
        User user = new User("UserTest", "PassTest", true);
        int before = repository.data.size();
        repository.addUser(user);
        int after = repository.data.size();

        User addedUser = null;
        for (User u :
                repository.data) {
            if (u.equals(user)){
                addedUser = u;
            }
        }

        assertNotEquals(before, after, "Add procedure is fail");
        assertEquals(user, addedUser, "Add procedure is fail");

    }

    @ParameterizedTest
    @ValueSource(strings = {"User-0", "User-9", "User-5"})
    @DisplayName("Test findByName if correct argument")
    void findByNameCorrectArgumentsCorrectResultTest(String arg) {
        assertTrue(repository.findByName(arg), "We have some problem here");
    }

    @Test
    void clearAuthenticate() {
        boolean isDone = false;
        repository.clearAuthenticate();
        for (User user:
             repository.data) {
            isDone = user.isAdmin() ? false : user.isAuthenticate;
            if (isDone) {
                break;
            }
        }

        assertTrue(!isDone, "Here is problem");
    }
}