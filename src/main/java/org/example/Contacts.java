package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contacts {
    public static void main(String[] args) {
        String directory = "data";

        String filename = "contacts.csv";

        Path dataDirectory = Paths.get(directory);

        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            try {
                Files.createDirectories(dataDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (Files.notExists(dataFile)) {
                try {
                    Files.createFile(dataFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        AddContact contact1 = new AddContact("Bob", 1234567891);
        AddContact contact2 = new AddContact("Timmy", 1234567891);
        AddContact contact3 = new AddContact("Tammy", 1234567891);
        AddContact contact4 = new AddContact("Tina", 1234567891);
        AddContact contact5 = new AddContact("Johny", 1234567891);
        AddContact contact6 = new AddContact("Billy", 1234567891);
        List<String> contacts = new ArrayList<>();

        contacts.add(contact1.getName() + ": " + contact1.getPhoneNumber());
        contacts.add(contact2.getName() + ": " + contact2.getPhoneNumber() );
        contacts.add(contact3.getName() + ": " + contact3.getPhoneNumber() );
        contacts.add(contact4.getName() + ": " + contact4.getPhoneNumber() );
        contacts.add(contact5.getName() + ": " + contact5.getPhoneNumber() );
        contacts.add(contact6.getName() + ": " + contact6.getPhoneNumber() );
        System.out.println(contacts);

        for (String contact : contacts) {
            contacts.add(contact);

        }

        try {
           Files.write(dataFile, contacts);

    } catch(IOException e){
            e.printStackTrace();
        }




        try{
            List<String> contactListFile = Files.readAllLines(dataFile);
            for(String line : contactListFile){
                String[] contactInfo = line.split(":");
                String name = contactInfo[0];
                String number = contactInfo[1];
                System.out.println(name + number);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

}
}
