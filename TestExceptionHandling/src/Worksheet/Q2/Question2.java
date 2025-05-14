package Worksheet.Q2;

/*
 * 2. Define a base custom exception `BankingException` and two subclasses: `InsufficientFundsException` and `InvalidAccountException`.
    Write a method `transferFunds()` that can throw either.
    Demonstrate catching them separately and together (by catching the parent).
 */

public class Question2 {

    public static void main(String[] args) {
        try {
            transferFunds("account1", "account2", 100.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient funds: " + e.getMessage());
        } catch (InvalidAccountException e) {
            System.out.println("Invalid account: " + e.getMessage());
        } catch (BankingException e) {
            System.out.println("General banking error: " + e.getMessage());
        }
    }

    static void transferFunds(String fromAccount, String toAccount, double amount)
            throws BankingException, InsufficientFundsException, InvalidAccountException {
        if (!fromAccount.equals("account1")) {
            throw new InvalidAccountException("Invalid 'from' account");
        }
        if (!toAccount.equals("account2")) {
            throw new InvalidAccountException("Invalid 'to' account");
        }
        if (amount > 50) {
            throw new InsufficientFundsException("Insufficient funds in account");
        }
        System.out.println("Funds transferred successfully");
    }
}