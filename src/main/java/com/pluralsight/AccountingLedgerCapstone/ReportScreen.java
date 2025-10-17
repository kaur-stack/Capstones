package com.pluralsight.AccountingLedgerCapstone;

import java.time.LocalDate;
import java.util.Scanner;

import static com.pluralsight.AccountingLedgerCapstone.TransactionFileManager.transactions;

/**
 * The ReportScreen class provides reporting features for the accounting ledger.
 * It allows users to view transactions filtered by specific time periods or by vendor.
 */
public class ReportScreen {
    static Scanner console = new Scanner(System.in);

    /**
     * Displays the report menu and handles user input for report generation.
     */
    public static void displayReportsMenu() {
        boolean goBack = false;

        while (!goBack) {
            AppScreens.displayReportsMenuScreen();
            System.out.print("|");
            String useInput = console.next().trim().toUpperCase();
            console.nextLine();
            AppScreens.displayPhoneBottom();

            switch (useInput) {
                case "1":
                    reportMonthToDate();
                    break;
                case "2":
                    reportPreviousMonth();
                    break;
                case "3":
                    reportYearToDate();
                    break;
                case "4":
                    reportPreviousYear();
                    break;
                case "5":
                    reportByVendor();
                    break;
                case "0":
                    goBack = true;
                    break;
                default:
                    System.out.println("⚠\uFE0F Invalid choice. Try again.");
                    break;
            }
        }
    }

    /**
     * Displays transactions from the current month to date.
     */
    public static void reportMonthToDate() {
        System.out.println("\n---- MONTH TO DATE ----");
        LocalDate now = LocalDate.now();
        printLedgerHeader();
        for (Transaction t : transactions) {
            if (t.getDate().getYear() == now.getYear() && t.getDate().getMonth() == now.getMonth()) {
                printTransaction(t);
            }
        }
        printLedgerFooter();
    }

    /**
     * Displays transactions from the previous month.
     */
    public static void reportPreviousMonth() {
        System.out.println("\n---- PREVIOUS MONTH ----");
        LocalDate now = LocalDate.now();
        LocalDate prevMonth = now.minusMonths(1);
        printLedgerHeader();
        for (Transaction t : transactions) {
            if (t.getDate().getYear() == prevMonth.getYear() && t.getDate().getMonth() == prevMonth.getMonth()) {
                printTransaction(t);
            }
        }
        printLedgerFooter();
    }

    /**
     * Displays transactions from the current year to date.
     */
    public static void reportYearToDate() {
        System.out.println("\n---- YEAR TO DATE ----");
        LocalDate now = LocalDate.now();
        printLedgerHeader();
        for (Transaction t : transactions) {
            if (t.getDate().getYear() == now.getYear()) {
                printTransaction(t);
            }
        }
        printLedgerFooter();
    }

    /**
     * Displays transactions from the previous calendar year.
     */
    public static void reportPreviousYear() {
        System.out.println("\n---- PREVIOUS YEAR ----");
        LocalDate now = LocalDate.now();
        int prevYear = now.getYear() - 1;
        printLedgerHeader();
        for (Transaction t : transactions) {
            if (t.getDate().getYear() == prevYear) {
                printTransaction(t);
            }
        }
        printLedgerFooter();
    }

    /**
     * Displays all transactions associated with a given vendor.
     * Prompts the user for a vendor name.
     */
    public static void reportByVendor() {
        System.out.println("\n---- SEARCH BY VENDOR ----");
        System.out.print("Enter vendor name: ");
        String vendor = console.nextLine().trim().toLowerCase();

        System.out.println("\n---- TRANSACTIONS FOR VENDOR: " + vendor + " ----");
        printLedgerHeader();
        for (Transaction t : transactions) {
            if (t.getVendor().toLowerCase().contains(vendor)) {
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
        System.out.printf("%-12s | %-15s | %-40s | %-30s | %10.2f\n",
                t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
    }

    private static void printLedgerFooter() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }
}