package org.example;

import java.io.IOException;

public class ContactsManager {
    public static void main(String[] args) throws IOException {
        ContactsFile contacts = new ContactsFile();
        contacts.printContacts();
//        contacts.deleteContact();
//        contacts.addContact();
        contacts.searchContact();



    }
}
