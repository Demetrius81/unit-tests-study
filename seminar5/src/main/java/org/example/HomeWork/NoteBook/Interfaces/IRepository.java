package org.example.HomeWork.NoteBook.Interfaces;

import org.example.HomeWork.NoteBook.Abstractions.Entity;
import org.example.HomeWork.NoteBook.Models.Contact;

import java.util.List;

public interface IRepository {
    public int addContact(Entity contact);

    public List<Contact> getContacts(int from, int count);

    public Entity updateContact(Entity contact);

    public Boolean removeContact(int id);
}
