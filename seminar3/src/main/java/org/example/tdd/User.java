package org.example.tdd;

import java.util.Objects;

public class User {

    String name;
    String password;

    public boolean isAdmin() {
        return isAdmin;
    }

    private final boolean isAdmin;

    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.isAdmin = false;
    }

    //3.6.
    public boolean authenticate(String name, String password) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isAdmin() == user.isAdmin() && isAuthenticate == user.isAuthenticate && Objects.equals(name, user.name) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, isAdmin(), isAuthenticate);
    }
}