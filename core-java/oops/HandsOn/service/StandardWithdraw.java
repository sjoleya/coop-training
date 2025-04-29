package HandsOn.service;

import HandsOn.model.BankAccount;

public class StandardWithdraw {
    public static void withdraw(BankAccount bankAccount, double amount) {
        bankAccount.balance -= amount;
    }
}
