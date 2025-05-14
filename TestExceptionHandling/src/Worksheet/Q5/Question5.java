package Worksheet.Q5;

/*
 * 5. Simulate a simple in-memory bank transfer system where moving funds between accounts must rollback if an exception occurs mid-operation (e.g., invalid target account).
 *  Use `try-catch` to ensure that no partial transfer leaves accounts in an inconsistent state.
 */

public class Question5 {

    private static double account1Balance = 100;
    private static double account2Balance = 50;

    public static void main(String[] args) {
        try {
            transferFunds("account1", "account2", 60);
            System.out.println("Transfer completed successfully.");
        } catch (InsufficientFundsException | InvalidAccountException e) {
            System.err.println("Transaction failed: " + e.getMessage());
        } finally {
            System.out.println("Account 1 balance: " + account1Balance);
            System.out.println("Account 2 balance: " + account2Balance);
        }
    }

    static void transferFunds(String fromAccount, String toAccount, double amount)
            throws InsufficientFundsException, InvalidAccountException {
        if (!fromAccount.equals("account1") || !toAccount.equals("account2")) {
            throw new InvalidAccountException("Invalid account");
        }

        if (account1Balance < amount) {
            throw new InsufficientFundsException("Insufficient funds");
        }

        double initialBalance1 = account1Balance;
        double initialBalance2 = account2Balance;

        try {
            account1Balance -= amount;
            account2Balance += amount;
        } catch (Exception e) {
            // Rollback
            account1Balance = initialBalance1;
            account2Balance = initialBalance2;
            throw e; // Re-throw the exception
        }
    }
}