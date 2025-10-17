package com.pluralsight.AccountingLedgerCapstone;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransactionFileManager {
    public static List<Transaction> transactions = new ArrayList<>();

    public static List<Transaction> loadTransaction(String fileName) {
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        List<Transaction> transactions = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            bufferedReader.readLine();

            String transStringLine;

            while((transStringLine = bufferedReader.readLine()) != null) {
                String[] transPartsArr = transStringLine.split("\\|");
                if (transPartsArr.length == 5) {
                    LocalDate date = LocalDate.parse(transPartsArr[0].trim(), dateTimeFormat);
                    LocalTime time = LocalTime.parse(transPartsArr[1].trim(), timeFormatter);
                    String description = transPartsArr[2].trim();
                    String vendor = transPartsArr[3].trim();
                    double amount = Double.parseDouble(transPartsArr[4].trim());
                    Transaction transaction = new Transaction(date, time, description, vendor, amount);
                    transactions.add(transaction);
                }

            }

        } catch (IOException exception) {
            System.out.println("⚠\uFE0F Error while reading transaction: " + exception.getMessage());
        }
        return transactions;
    }

    public static void saveTransaction(Transaction transaction, String fileName) {
        if (transaction == null || fileName.isEmpty()) {
            System.out.println("⚠\uFE0F Invalid transaction or filename.");
        }
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String record = String.format("%s|%s|%s|%s|%.2f%n", transaction.getDate(), transaction.getTime(), transaction.getDescription(), transaction.getVendor(), transaction.getAmount());
            bufferedWriter.write(record);
            bufferedWriter.close();
            transactions.add(transaction);

        } catch (IOException exception) {
            System.out.println("⚠\uFE0F Error while writing to transaction file: " + exception.getMessage());
        }
    }

}

