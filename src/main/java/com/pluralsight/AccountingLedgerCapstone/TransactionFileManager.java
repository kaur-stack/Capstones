package com.pluralsight.AccountingLedgerCapstone;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransactionFileManager {
    public static List<Transaction> transactions = new ArrayList<>();
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void loadTransaction(String fileName) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            bufferedReader.readLine();

            String transStringLine;

            while((transStringLine = bufferedReader.readLine()) != null) {
                String[] transPartsArr = transStringLine.split("\\|");
                if (transPartsArr.length == 5) {
                    LocalDate date = LocalDate.parse(transPartsArr[0].trim(), dateFormatter);
                    // Strip nanoseconds if present before parsing
                    String rawTime = transPartsArr[1].trim();
                    if (rawTime.contains(".")) {
                        rawTime = rawTime.substring(0, rawTime.indexOf("."));
                    }
                    LocalTime time = LocalTime.parse(rawTime, timeFormatter);
                    
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
    }

    public static void storeTransaction(Transaction transaction, String fileName) {
        if (transaction == null || fileName.isEmpty()) {
            System.out.println("⚠\uFE0F Invalid transaction or filename.");
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));

            String record = String.format("%s|%s|%s|%s|%.2f%n",
                    transaction.getDate().format(dateFormatter),
                    transaction.getTime().format(timeFormatter),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount());

            bufferedWriter.write(record);
            bufferedWriter.newLine();
            bufferedWriter.close();

            transactions.add(transaction);

        } catch (IOException exception) {
            System.out.println("⚠\uFE0F Error while writing to transaction file: " + exception.getMessage());
        }
    }

}

