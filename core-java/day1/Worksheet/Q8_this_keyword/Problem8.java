package Worksheet.Q8_this_keyword;

/*
Design a BankAccount class with fields like name, balance, and type. Use this keyword in
the constructor and in a method that updates the balance. Show how this resolves variable
shadowing.
 */

class BankAccount {
    private String name;
    private double balance;
    private String type;

    public BankAccount(String name, double balance, String type) {
        this.name = name;         // 'this.name' refers to the field, 'name' is the parameter
        this.balance = balance;
        this.type = type;
    }

    public void updateBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.err.println("Invalid balance amount. Must be non-negative.");
        }
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

    public void displayDetails() {
        System.out.println("Account Holder: " + this.name);
        System.out.println("Account Type: " + this.type);
        System.out.println("Current Balance: ₹" + this.balance);
    }
}

public class Problem8 {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Sarthak", 1000.50, "Savings");
        account1.displayDetails();
        System.out.println();

        account1.updateBalance(1500.75);
        System.out.println("Balance after update:");
        account1.displayDetails();
        System.out.println();

        // Attempting to update with an invalid balance
        account1.updateBalance(-200);
        System.out.println("Balance after attempting invalid update:");
        account1.displayDetails();
    }
}
