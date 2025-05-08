package Worksheet.Q2_Bank_Account_Synchronisation;

import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private final String accountNumber;
    private double balance;
    private final ReentrantLock lock = new ReentrantLock(); // Per-account lock
    private final List<Transaction> transactionLog = new ArrayList<>();

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        logTransaction("INITIAL_BALANCE", initialBalance, initialBalance);
    }

    public String getAccountId() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.printf("Thr-%s | Acc-%s | Invalid deposit amount: %.2f\n",
                    Thread.currentThread().getName(), accountNumber, amount);
            return;
        }
        lock.lock();
        try {
            balance += amount;
            logTransaction("DEPOSIT", amount, balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.printf("Thr-%s | Acc-%s | Invalid withdraw amount: %.2f\n",
                    Thread.currentThread().getName(), accountNumber, amount);
            return;
        }
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                logTransaction("WITHDRAWAL_SUCCESS", amount, balance);
            } else {
                logTransaction("WITHDRAWAL_FAIL_INSUFFICIENT", amount, balance);
            }
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionLog() {
        System.out.println("\n--- Transaction Log for Account: " + accountNumber + " ---");
        if (transactionLog.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        for (Transaction tx : transactionLog) {
            System.out.println(tx);
        }
        System.out.println("-------------------------------------------------");
    }

    private void logTransaction(String type, double amount, double balanceAfter) {
        Transaction transaction = new Transaction(
                Thread.currentThread().getName(),
                this.accountNumber,
                type,
                amount,
                balanceAfter);
        transactionLog.add(transaction);
        System.out.println(transaction);
    }
}
