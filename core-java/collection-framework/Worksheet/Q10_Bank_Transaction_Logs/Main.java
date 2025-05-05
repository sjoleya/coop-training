package Worksheet.Q10_Bank_Transaction_Logs;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, List<Transaction>> accountLogs = new HashMap<>();

        logTransaction(accountLogs, "ACC123",
                new Transaction(LocalDateTime.of(2023, 5, 10, 9, 0), 1000.0, "Initial Deposit"));
        logTransaction(accountLogs, "ACC123",
                new Transaction(LocalDateTime.of(2023, 5, 12, 12, 30), -150.0, "Grocery Shopping"));
        logTransaction(accountLogs, "ACC123",
                new Transaction(LocalDateTime.of(2023, 5, 13, 16, 45), -75.0, "Electricity Bill"));

        logTransaction(accountLogs, "ACC456", new Transaction(LocalDateTime.of(2023, 5, 11, 10, 15), 700.0, "Deposit"));
        logTransaction(accountLogs, "ACC456",
                new Transaction(LocalDateTime.of(2023, 5, 12, 18, 0), -100.0, "Dining Out"));

        logTransaction(accountLogs, "ACC789", new Transaction(LocalDateTime.of(2023, 5, 14, 8, 30), 1200.0, "Salary"));
        logTransaction(accountLogs, "ACC789",
                new Transaction(LocalDateTime.of(2023, 5, 15, 13, 0), -300.0, "Car Maintenance"));

        generateStatement(accountLogs, "ACC123");
        generateStatement(accountLogs, "ACC456");
        generateStatement(accountLogs, "ACC789");
    }

    private static void logTransaction(Map<String, List<Transaction>> map, String account, Transaction txn) {
        map.computeIfAbsent(account, _ -> new ArrayList<>()).add(txn);
    }

    private static void generateStatement(Map<String, List<Transaction>> map, String account) {
        System.out.println("\nStatement for Account: " + account);
        List<Transaction> transactions = map.getOrDefault(account, Collections.emptyList());

        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getTime))
                .forEach(System.out::println);
    }
}
