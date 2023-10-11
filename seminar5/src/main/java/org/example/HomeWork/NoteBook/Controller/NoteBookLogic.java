package org.example.HomeWork.NoteBook.Controller;

import org.example.HomeWork.NoteBook.Abstractions.Entity;
import org.example.HomeWork.NoteBook.Interfaces.ILogic;
import org.example.HomeWork.NoteBook.Interfaces.IRepository;
import org.example.HomeWork.NoteBook.Models.Contact;

import java.util.List;

public class NoteBookLogic implements ILogic {
    private final IRepository repository;
    public NoteBookLogic(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public int addContact(Entity contact) {
        if (contact == null) {
            return -1;
        }
        return repository.addContact(contact);
    }

    @Override
    public List<Contact> getContacts(int from, int count) {
        if (from < 0 || count <= 0) {
            return null;
        }
        return repository.getContacts(from, count);
    }

    @Override
    public Entity updateContact(Entity contact) {
        if (contact == null) {
            return null;
        }
        return repository.updateContact(contact);
    }

    @Override
    public Boolean removeContact(int id) {
        if (id < 0 ) {
            return false;
        }
        return repository.removeContact(id);
    }
}
