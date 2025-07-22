package Worksheet.Q2_Bank_Account_Synchronisation;

/*
Assignment 2: Bank Account Synchronization
Background:
Simulate a multi-threaded banking system that supports concurrent deposits and withdrawals from shared accounts.

Requirements:
- Implement a BankAccount class with:
    - Methods: deposit(double amount), withdraw(double amount)
    - Thread-safe balance modification
- Create multiple threads representing users performing deposits and withdrawals
- Ensure no overdrawing and correct final balance

Bonus Requirements:
- Add transaction logging
- Add per-account lock to prevent locking the entire bank
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Bank Account Synchronization Simulation ---");

        BankAccount account1 = new BankAccount("ACC001", 1000.00);
        BankAccount account2 = new BankAccount("ACC002", 500.00);

        System.out.println("\nInitial Balances:");
        System.out.printf("Account %s: %.2f\n", account1.getAccountId(), account1.getBalance());
        System.out.printf("Account %s: %.2f\n", account2.getAccountId(), account2.getBalance());
        System.out.println("\n--- Starting User Transactions ---");

        // Stress Testing
        Thread user1_acc1 = new Thread(new UserAction(account1, 5), "User1");
        Thread user2_acc1 = new Thread(new UserAction(account1, 7), "User2");
        Thread user3_acc2 = new Thread(new UserAction(account2, 6), "User3");
        Thread user4_acc2 = new Thread(new UserAction(account2, 4), "User4");
        Thread user5_acc1_dep = new Thread(() -> { // A user only depositing to acc1
            for (int i = 0; i < 3; i++)
                account1.deposit(200);
        }, "User5-Deposit");
        Thread user6_acc2_wit = new Thread(() -> { // A user only withdrawing from acc2
            for (int i = 0; i < 2; i++)
                account2.withdraw(100);
        }, "User6-Withdraw");

        user1_acc1.start();
        user2_acc1.start();
        user3_acc2.start();
        user4_acc2.start();
        user5_acc1_dep.start();
        user6_acc2_wit.start();

        try {
            user1_acc1.join();
            user2_acc1.join();
            user3_acc2.join();
            user4_acc2.join();
            user5_acc1_dep.join();
            user6_acc2_wit.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted while waiting for user threads.");
            Thread.currentThread().interrupt();
        }

        System.out.println("\n--- All User Transactions Completed ---");

        // Print final balances
        System.out.println("\nFinal Balances:");
        System.out.printf("Account %s: %.2f\n", account1.getAccountId(), account1.getBalance());
        System.out.printf("Account %s: %.2f\n", account2.getAccountId(), account2.getBalance());

        account1.printTransactionLog();
        account2.printTransactionLog();

        System.out.println("\n--- Simulation Ended ---");
    }

}
