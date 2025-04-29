package HandsOn.service;

import HandsOn.model.BankAccount;

public class StandardDeposit {
    public static void deposit(BankAccount bankAccount, double amount) {
        bankAccount.balance += amount;
    }
}
