package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.example.Input;

public class ContactsFile {
    private Path file;
    public List<String> contacts;

    public ContactsFile(){
        this.file = Paths.get("data", "contacts.csv");
        this.updateContacts();
    }

    public void updateContacts(){
        this.contacts = new ArrayList<>();
        try{
            this.contacts = Files.readAllLines(this.file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void printContacts(){

    }
    public void addContact(){

    }
    public void deleteContact(){
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
        if(lines.contains(input)){
            lines.remove(input);
            try {
                Files.write(this.file, lines);
                System.out.println("Contact deleted successfully");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Contact not found");
        }
        System.out.println("Contacts in list: " + this.contacts);
        System.out.println("Input: " + input);

    }

    public void searchContact(){

    }


}
