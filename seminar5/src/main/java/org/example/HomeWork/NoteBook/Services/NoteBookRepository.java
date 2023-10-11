package org.example.HomeWork.NoteBook.Services;

import org.example.HomeWork.NoteBook.Abstractions.Entity;
import org.example.HomeWork.NoteBook.Interfaces.IRepository;
import org.example.HomeWork.NoteBook.Models.Contact;

import java.util.ArrayList;
import java.util.List;

public class NoteBookRepository implements IRepository {
    private static IRepository instance;
    private NoteBookRepository() {
    }
    public static IRepository getInstance(){
        return instance == null ? new NoteBookRepository() : instance;
    }

    @Override
    public int addContact(Entity contact) {
        return contact.getId();
    }

    @Override
    public List<Contact> getContacts(int from, int count) {
        List<Contact> result = new ArrayList<Contact>();
        int j = from;

        for (int i = 0; i < count; i++) {
            result.add(new Contact(j++));
        }

        return result;
    }

    @Override
    public Entity updateContact(Entity contact) {
        return contact;
    }

    @Override
    public Boolean removeContact(int id) {
        return true;
    }
}
