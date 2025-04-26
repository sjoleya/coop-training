package HandsOn.Services;

import HandsOn.Models.BankAccount;

public class StandardWithdraw {
    public static void withdraw(BankAccount bankAccount, double amount) {
        bankAccount.balance -= amount;
    }
}
