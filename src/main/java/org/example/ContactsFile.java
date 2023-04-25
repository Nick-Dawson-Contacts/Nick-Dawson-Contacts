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
        try {
            List<String> contactsFromFile = Files.readAllLines(this.file);
            System.out.println(contactsFromFile);
            for(int i = 1; i <= contactsFromFile.size(); i+=1){
                System.out.println( i + ": " + contactsFromFile.get(i-1));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the name,number of the person you're adding?");
        String input = scanner.nextLine();
        List<String> lines;
        try {
            lines = Files.readAllLines(this.file);
        } catch (IOException e){
            e.printStackTrace();
            return;
        }
        if(!lines.contains(input)){
            lines.add(input);
            try {
                Files.write(
                        this.file,
                        lines,
                        StandardOpenOption.WRITE
                );
            }catch(IOException e){
                e.printStackTrace();
            }
            System.out.println("Contact added successfully.");
        } else{
            System.out.println("Contact already exists.");
        }
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
    }

    public void searchContact(){

    }


}
