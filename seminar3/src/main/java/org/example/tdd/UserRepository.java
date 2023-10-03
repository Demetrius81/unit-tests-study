package org.example.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) throws RuntimeException {
        // Validation
        if (user == null) {
            throw new RuntimeException("Parameter is null");
        }

        if (user.name == null || user.password == null) {
            throw new RuntimeException("One of the parameter fields is null");
        }

        if (user.name.isEmpty() || user.name.isBlank() || user.name.length() < 2) {
            throw new RuntimeException("User name is too short or empty");
        }

        if (user.password.isEmpty() || user.password.isBlank() || user.password.length() < 2) {
            throw new RuntimeException("User password is too short or empty");
        }

        data.add(user);
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void clearAuthenticate(){
        for (User user:
             data) {
            if (!user.isAdmin()) {
                user.isAuthenticate = false;
            }
        }
    }

}