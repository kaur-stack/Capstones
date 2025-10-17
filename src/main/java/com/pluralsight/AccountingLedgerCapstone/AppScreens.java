package com.pluralsight.AccountingLedgerCapstone;

public class AppScreens {
    public static void displayWelcomeScreen() {
        displayPhoneTop();
        System.out.println("|--------------------------------|");
        System.out.println("|                                |");
        System.out.println("|                                |");
        System.out.println("|          WELCOME USER          |");
        System.out.println("|                                |");
        System.out.println("|             say hi!            |");
        System.out.println("|--------------------------------|");
    }
    public static void displayPhoneTop() {
        System.out.println("   ____________________________");
        System.out.println(" /  ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄  \\");
        System.out.println("|  |      ●     ▂▂▂▂▂         |  |");
        System.out.println("|  |__________________________|  |");
    }

    public static void displayPhoneBottom() {
        System.out.println("|                                |");
        System.out.println("|              ⬤                |");
        System.out.println(" \\______________________________/");
        System.out.println();
    }

    public static void displayMainMenuScreen() {
        displayPhoneTop();
        System.out.println("|          📱 MAIN MENU          |");
        System.out.println("|--------------------------------|");
        System.out.println("|  D) Add Deposit                |");
        System.out.println("|  P) Make Payment (Debit)       |");
        System.out.println("|  L) Ledger                     |");
        System.out.println("|  X) Exit                       |");
        System.out.println("|                                |");
        System.out.println("|--------------------------------|");
        System.out.println("|  Please enter your choice:     |");
    }

    public static void displayLedgerMenuScreen() {
        displayPhoneTop();
        System.out.println("|          📒 LEDGER MENU        |");
        System.out.println("|--------------------------------|");
        System.out.println("|  A) All Entries (Newest First) |");
        System.out.println("|  D) Deposits Only              |");
        System.out.println("|  P) Payment Only               |");
        System.out.println("|  R) Reports Menu               |");
        System.out.println("|  H) Return to Home Screen      |");
        System.out.println("|--------------------------------|");
        System.out.println("|  Please enter your choice:     |");
    }

    public static void displayReportsMenuScreen() {
        displayPhoneTop();
        System.out.println("|         📊 REPORTS MENU        |");
        System.out.println("|--------------------------------|");
        System.out.println("|  1) Month To Date              |");
        System.out.println("|  2) Previous Month             |");
        System.out.println("|  3) Year To Date               |");
        System.out.println("|  4) Previous Year              |");
        System.out.println("|  5) Search by Vendor           |");
        System.out.println("|  0) Back (to Ledger page)      |");
        System.out.println("|--------------------------------|");
        System.out.println("|  Please enter your choice:     |");
    }
}
