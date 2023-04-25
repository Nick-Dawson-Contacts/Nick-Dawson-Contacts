package org.example;

import java.io.IOException;
import java.util.Scanner;

public class ContactsManager {
    public static void main(String[] args) throws IOException {
        ContactsFile contacts = new ContactsFile();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("---------------\n1. View Contacts.\n2. Add a new contact.\n3. Search a contact by name.\n" +
                    "4. Delete an existing contact.\n5. Exit.\nEnter an option (1, 2, 3, 4 or 5):\n" );
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    contacts.printContacts();
                    break;
                case 2:
                    contacts.addContact();
                    break;
                case 3:
                    contacts.searchContact();
                    break;
                case 4:
                    contacts.deleteContact();
                    break;
                case 5:
                    System.out.println("Have a great day! Goodbye.");
                    System.exit(0);
                    break;
            }
        }
    }
}

