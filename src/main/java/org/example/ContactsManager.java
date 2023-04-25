package org.example;

import java.io.IOException;
import java.util.Scanner;

public class ContactsManager {
    public static void main(String[] args) throws IOException {
        ContactsFile contacts = new ContactsFile();
//        contacts.printContacts();
//        contacts.addContact();
//        contacts.deleteContact();
//        contacts.searchContact();
        Scanner scanner = new Scanner(System.in);
//        Menu homeScreen = new Menu();
//        System.out.println(homeScreen);
        System.out.println("1-5");
        int input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1:
                    input = 1;
                    contacts.printContacts();
                    break;
                case 2:
                    input = 2;
                    contacts.addContact();
                    break;
                case 3:
                    input = 3;
                    contacts.deleteContact();
                    break;
                case 4:
                    input = 4;
                    contacts.searchContact();
                    break;
                case 5:
                    input = 5;
                    System.out.println("Have a great day! Goodbye.");
                    break;
            }
        }
    }

