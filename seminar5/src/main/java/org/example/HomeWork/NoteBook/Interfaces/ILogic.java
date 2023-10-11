package org.example.HomeWork.NoteBook.Interfaces;

import org.example.HomeWork.NoteBook.Abstractions.Entity;
import org.example.HomeWork.NoteBook.Models.Contact;

import java.util.List;

public interface ILogic {
// метод сохраняет в базу данных контакт и возвращает идентификатор сохраненного контакта в случае успешного сохранения
// или -1 в случае ошибки
    public int addContact(Entity contact);

// метод возвращает список из count контактов, начиная с контакта с идентификатором from, либо null в случае ошибки.
    public List<Contact> getContacts(int from, int count);

// метод обновляет имеющийся в базе данных контакт и возврашает обновленный контакт или в случае ошибки null.
    public Entity updateContact(Entity contact);

// метод удаляет контакт из базы данных по идентификатору и возвращает true если контакт удален либо false в случае ошибки.
    public Boolean removeContact(int id);
}
