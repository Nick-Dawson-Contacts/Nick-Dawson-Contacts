package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsFile {
    private Path file;
    public List<String> contacts;


    public ContactsFile() {
        this.file = Paths.get("data", "contacts.csv");
        this.updateContacts();
    }

    public void updateContacts() {
        this.contacts = new ArrayList<>();
        try {
            this.contacts = Files.readAllLines(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printContacts(){
        updateContacts();
        System.out.println("=======================");
        System.out.println("Name   |   Phone Number");
        System.out.println(".......................");
        for (String line : this.contacts){
            String[] displayContacts = line.split(",");
            String name = displayContacts[0];
            String number = displayContacts[1];
            System.out.println(name + "  |  " + number);
        }
        System.out.println("=======================");
    }

    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name,number of the person you're adding?");
        String input = scanner.nextLine();
        updateContacts();
        if (!this.contacts.contains(input)) {
            contacts.add(input);
            try {
                Files.write(
                        this.file,
                        this.contacts,
                        StandardOpenOption.WRITE
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Contact added successfully.");
        } else {
            System.out.println("Contact already exists.");
        }
    }

    public void deleteContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What contact would you like to delete?");
        String input = scanner.nextLine();
        updateContacts();
        boolean found = false;
        List<String> linesToRemove = new ArrayList<>();
        for (String line : this.contacts) {
            String[] contactInfo = line.split(",");
            String name = contactInfo[0];
            String number = contactInfo[1];
            if (name.equals(input) || number.equals(input)) {
                linesToRemove.add(line);
                found = true;
            }
        }
        if (found) {
            contacts.removeAll(linesToRemove);
            try {
                Files.write(this.file, this.contacts);
                System.out.println("Contact deleted successfully");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Contact not found: " + input);
        }
    }

    public void searchContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What contact would you like to see?");
        String input = scanner.nextLine();
        updateContacts();
        boolean found = false;
        for (String line : this.contacts) {
            String[] contactInfo = line.split(",");
            String name = contactInfo[0];
            String number = contactInfo[1];
            if (name.equalsIgnoreCase(input)) {
                System.out.println("Contact information for " + name + ":");
                System.out.println("Name: " + name);
                System.out.println("Number: " + number);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found: " + input);
        }
    }

}
