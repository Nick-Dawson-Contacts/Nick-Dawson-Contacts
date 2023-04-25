package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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

    public void printContacts(){}


}
