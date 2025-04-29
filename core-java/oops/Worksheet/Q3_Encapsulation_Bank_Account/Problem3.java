package Worksheet.Q3_Encapsulation_Bank_Account;

/*
Create a `BankAccount` class with private fields `accountHolder`, `balance`, and `accountNumber`.
Use getters and setters with validation: prevent setting a negative balance.
 */

class BankAccount {
    private String accountHolder;
    private double balance;
    private final String accountNumber;

    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        setBalance(initialBalance); // Use setter to apply validation
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.err.println("Balance cannot be negative.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.err.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.err.println("Invalid withdraw amount.");
        }
    }
}


public class Problem3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Sarthak", "123456789", 1000);

        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Initial Balance: ₹" + account.getBalance());

        account.deposit(500);
        System.out.println("Balance after deposit: ₹" + account.getBalance());

        account.withdraw(200);
        System.out.println("Balance after withdrawal: ₹" + account.getBalance());

        account.setBalance(-300); // Should show validation warning
    }
}
