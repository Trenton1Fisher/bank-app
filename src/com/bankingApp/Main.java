package com.bankingApp;

import com.bankingApp.owner.Owner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        Owner userOwner = new Owner();

        System.out.println("Welcome to the CLI Banking System!");

        while (running) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. View Banks");
            System.out.println("2. View Net Worth");
            System.out.println("3. Next Day");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    userOwner.viewBanks();
                    break;
                case 2:
                    System.out.println("Your current overall Networth: " + userOwner.getOwnerNetworth());
                    break;
                case 3:
                    
                    boolean newBank = userOwner.goToNextDay();
                    if(newBank){
                        System.out.println("Congratulations! You can now purchase another bank.");
                        System.out.print("Please provide the name of your new bank: ");
                        String newBankName = scanner.nextLine();
                        userOwner.makeNewBank(newBankName);
                        System.out.println("You have successfully purchased: " + newBankName);
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Thank you for using the CLI Banking System!");
    }
}
