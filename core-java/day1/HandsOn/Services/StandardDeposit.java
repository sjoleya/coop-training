package HandsOn.Services;

import HandsOn.Models.BankAccount;

public class StandardDeposit {
    public static void deposit(BankAccount bankAccount, double amount) {
        bankAccount.balance += amount;
    }
}
