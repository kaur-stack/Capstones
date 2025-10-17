package com.pluralsight.AccountingLedgerCapstone;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class PennyPilot {
    static Scanner console = new Scanner(System.in);
    static String fileName = "files/transactions.csv";

    public static void main(String[] args) {
        AppScreens.displayWelcomeScreen();
        System.out.print("|");
        console.next(); // saying hi to go to homeMenu
        console.nextLine(); //clears leftover newline!
        AppScreens.displayPhoneBottom();

        homeScreen();

    }
    public static void homeScreen() {
        boolean endProgram = false;

        while(!endProgram) {
            AppScreens.displayMainMenuScreen();
            System.out.print("|");
            String useInput = console.next().trim().toUpperCase();
            console.nextLine(); //clears leftover newline!
            AppScreens.displayPhoneBottom();

            switch (useInput) {
                case "D":
                    addDeposit();
                    break;
                case "P":
                    makePayment();
                    break;
                case "L":
                    LedgerScreen.ledgerMenu();
                    break;
                case "X":
                    endProgram = true;
                    AppScreens.displayExitScreen();
                    break;
                default:
                    System.out.println("⚠\uFE0F Not a valid choice. Please select D, P, L, or X");
                    break;
            }
        }
    }

    public static void addDeposit() {
        System.out.println("\n--- ADD A DEPOSIT ---");
        // current date
        LocalDate date = LocalDate.now();
        // current time
        LocalTime time = LocalTime.now();
        System.out.print("Enter Description: ");
        String description = console.nextLine();

        System.out.print("Enter vendor: ");
        String vendor = console.nextLine();

        System.out.print("Enter Amount: ");
        double amount = console.nextDouble();
        console.nextLine();

        Transaction transaction = new Transaction(date, time, description, vendor, amount);
        TransactionFileManager.storeTransaction(transaction, fileName);

        System.out.println("✅ Deposit saved successfully!");
    }

    public static void makePayment() {
        System.out.println("\n--- MAKE A PAYMENT ---");

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.print("Enter description: ");
        String description = console.nextLine();

        System.out.print("Enter vendor: ");
        String vendor = console.nextLine();

        System.out.print("Enter amount: ");
        double amount = console.nextDouble();
        console.nextLine(); // consume newline

        // making sure payments are negative
        double payAmount = amount * -1;

        Transaction transaction = new Transaction(date, time, description, vendor, payAmount);
        TransactionFileManager.storeTransaction(transaction, fileName);

        System.out.println("✅ Payment saved successfully!");
    }
}
