package com.pluralsight.AccountingLedgerCapstone;

import java.util.Scanner;

import static com.pluralsight.AccountingLedgerCapstone.TransactionFileManager.transactions;

/**
 * The LedgerScreen class handles displaying all transactions from the ledger.
 * It allows the user to view transactions, filter them by deposits or payments,
 * and navigate to the reporting or main menu screens.
 */
public class LedgerScreen {
    static Scanner console = new Scanner(System.in);

    /**
     * Displays the ledger menu and handles user input for navigation and filtering.
     * Shows transactions in reverse chronological order (most recent first).
     */
    public static void ledgerMenu() {
        boolean goBackHome = false;

        while(!goBackHome) {
            AppScreens.displayLedgerMenuScreen();
            System.out.print("|");
            String useInput = console.next().trim().toUpperCase();
            console.nextLine();
            AppScreens.displayPhoneBottom();

            switch (useInput) {
                case "A":
                    displayAllEntries();
                    break;
                case "D":
                    displayDeposits();
                    break;
                case "P":
                    displayPayments();
                    break;
                case "R":
                    ReportScreen.displayReportsMenu();
                    break;
                case "H":
                    goBackHome = true;
                    break;
                default:
                    System.out.println("⚠\uFE0F Not a valid choice. Please select A, D, P, R, or H");
                    break;
            }
        }
    }

    /**
     * Displays all transactions in reverse order (latest first).
     */
    public static void displayAllEntries() {
        System.out.println("\n---- ALL TRANSACTIONS----");
        printLedgerHeader();

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (int i = transactions.size() - 1; i >= 0; i--) {
            printTransaction(transactions.get(i));
        }
        printLedgerFooter();
    }

    /**
     * Displays only deposit (positive) transactions.
     */
    public static void displayDeposits() {
        System.out.println("\n---- DEPOSITS ONLY ----");
        printLedgerHeader();
        for (Transaction t : transactions) {
            if (t.getAmount() > 0) {
                printTransaction(t);
            }
        }
        printLedgerFooter();
    }

    /**
     * Displays only payment (negative) transactions.
     */
    public static void displayPayments() {
        System.out.println("\n---- PAYMENTS ONLY ----");
        printLedgerHeader();
        for (Transaction t : transactions) {
            if (t.getAmount() < 0) {
                printTransaction(t);
            }
        }
        printLedgerFooter();
    }

    private static void printLedgerHeader() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-12s | %-15s | %-40s | %-30s | %-10s\n",
                "Date", "Time", "Description", "Vendor", "Amount");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    private static void printTransaction(Transaction t) {
        System.out.printf("%-12s | %-15s | %-40s | %-30s | %-10.2f\n",
                t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
    }

    private static void printLedgerFooter() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }
}
