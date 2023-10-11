package org.example.HomeWork.NoteBook.Abstractions;

public abstract class Entity {
    private int id;

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
