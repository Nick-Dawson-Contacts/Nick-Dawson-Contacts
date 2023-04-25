package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.example.Input;

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
        List<String> lines;
        try{
            lines = Files.readAllLines(this.file);
        } catch(IOException e){
            e.printStackTrace();
            return;
        }
        System.out.println("Name   |   Phone Number");
        System.out.println("=======================");
        for (String line : lines){
            String[] displayContacts = line.split(",");
            String name = displayContacts[0];
            String number = displayContacts[1];
            System.out.println(name + "  |  " + number);
        }
    }

    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name,number of the person you're adding?");
        String input = scanner.nextLine();
        List<String> lines;
        try {
            lines = Files.readAllLines(this.file);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        if (!lines.contains(input)) {
            lines.add(input);
            try {
                Files.write(
                        this.file,
                        lines,
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
        List<String> lines;
        try {
            lines = Files.readAllLines(this.file);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        boolean found = false;
        List<String> linesToRemove = new ArrayList<>();
        for (String line : lines) {
            String[] contactInfo = line.split(",");
            String name = contactInfo[0];
            String number = contactInfo[1];
            if (name.equals(input) || number.equals(input)) {
                linesToRemove.add(line);
                found = true;
            }
        }
        if (found) {
            lines.removeAll(linesToRemove);
            try {
                Files.write(this.file, lines);
                System.out.println("Contact deleted successfully");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e + "this one 2");
            }
        } else {
            System.out.println("Contact not found: " + input);
        }
    }

    public void searchContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What contact would you like to see?");
        String input = scanner.nextLine();
        List<String> lines;
        try {
            lines = Files.readAllLines(this.file);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        boolean found = false;
        for (String line : lines) {
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
