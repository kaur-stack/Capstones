package com.pluralsight.AccountingLedgerCapstone;

/**
 * The AppScreens class contains reusable UI components
 * that display various menus and visual sections for the PennyPilot console app.
 */
public class AppScreens {
    /** Displays the welcome screen. */
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

    /** Displays the top of the phone. */
    public static void displayPhoneTop() {
        System.out.println("   ____________________________");
        System.out.println(" /  ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄  \\");
        System.out.println("|  |          ▂▂▂▂▂   ●       |  |");
        System.out.println("|  |__________________________|  |");
    }

    /** Displays the bottom of the phone. */
    public static void displayPhoneBottom() {
        System.out.println("|                                |");
        System.out.println("|              ⬤                |");
        System.out.println(" \\______________________________/");
    }

    /** Displays the main home menu. */
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

    /** Displays the ledger submenu options. */
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

    /** Displays the reports menu options. */
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

    /** Displays a goodbye. */
    public static void displayExitScreen() {
        displayPhoneTop();
        System.out.println("|--------------------------------|");
        System.out.println("|                                |");
        System.out.println("|                                |");
        System.out.println("|          EXIT PROGRAM          |");
        System.out.println("|          GOODBYE\uD83D\uDC4B!            |");
        System.out.println("|                                |");
        System.out.println("|--------------------------------|");
        displayPhoneBottom();
    }
}
