package org.example;
import java.util.Scanner;

//public class Input {
//    public static void main(String[] args) {}
//
//    private Scanner scanner;
//
//    public Input(){
//        scanner = new Scanner(System.in);
//    }
//
//    public String getString(){
//        return scanner.nextLine();
//    }
//    public boolean yesNo(){
//        while(true){
//            System.out.println("Would you like to continue? [y,N]");
//            String input = scanner.nextLine().trim();
//            if (input.equalsIgnoreCase("y")){
//                return true;
//            } else if (input.equalsIgnoreCase("n")){
//                return false;
//            } else {
//                System.out.println("Invalid input.");
//            }
//        }
//    }
//
//    public int getInt(int min, int max){
//        while(true) {
//            System.out.printf("Please enter a number between %d and %d.", min, max);
//            try{
//                int input = scanner.nextInt();
//                scanner.nextLine();
//                if(input >= min || input <= max){
//                    return input;
//                } else {
//                    System.out.println("invalid input");
//                }
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    public int getDouble(){
//
//        return 2;
//    }
//
//}

public class Input {
    private Scanner scanner;
    public Input(){
        this.scanner = new Scanner(System.in);
    }

    public String getString(){
        System.out.println("Enter a string: ");
        return scanner.nextLine();
    }

    public String getString(String prompt){
        System.out.println(prompt);
        return scanner.nextLine();
    }
/*
    public boolean yesNo2(){
        System.out.println("Do you want to continue?  [y/N]");
        String userChoice = scanner.nextLine();
        return userChoice.nextLine().equalsIgnoreCase("y") || userChoice.nextLine().equalsIgnoreCase("yes");
    }
*/
    // short circuit: the code will meet a requirement and stop running there like a break.
    // in the case below if entered "y" the code will not run the OR statement.
    // use this yesNo method in combination with getString. Pass the return from getString
    public boolean yesNo(String input){
        return input.trim().equals("y") || input.trim().equalsIgnoreCase("yes");
    }

    public int getInterger(int min, int max){
        System.out.println("Please enter a number between" + min + "and" + max + ":");
        int num = scanner.nextInt();
        if (num >= min && num <= max){
            return num;
        } else {
            return getInterger(min, max);
        }
    }

//    public int getInt(){
//        System.out.println("Enter an interger: ");
//        return scanner.nextInt();
//    }
    public int getInt(String prompt){
        System.out.println(prompt);
        return scanner.nextInt();
    }
//    public int getInt(){
//        System.out.println("Enter an interger:");
//        String userInput = getString();
//        try{
//            Integer.valueOf(userInput);
//        } catch(NumberFormatException){
//            System.out.println("You did not enter a valid number. Please try again");
//            getInt();
//        }
//        return Integer.parseInt(userInput);
//    }

    /*public int getInt(String prompt) {
        while (true) {
            try {
                String inputStr = getString(prompt);
                if (inputStr == null || inputStr.isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be null or empty");
                }
                return Integer.valueOf(inputStr);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter an integer.");
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }*/

    public double getDouble(double min, double max) {
        System.out.printf("Enter a number between %.1f and %.1f: ", min, max);
        double userNum = scanner.nextDouble();
        if (userNum >= min && userNum <= max) {
            return userNum;
        }
        return getDouble(min, max);
    }

    public double getDouble(){
        System.out.println("Enter a number: (decimals allowed) ");
        return scanner.nextDouble();
    }
    public double getDouble(String prompt){
        System.out.println(prompt);
        return scanner.nextDouble();
    }
    public void getGhost(){
        System.out.println("");
        String ghost = scanner.nextLine();
    }



}





