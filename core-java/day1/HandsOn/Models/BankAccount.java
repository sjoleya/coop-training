package HandsOn.Models;

public abstract class BankAccount {
    public String accountNumber;
    public double balance;
    public abstract String getAccountType();
    public BankAccount(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public double getBalance() {
        return this.balance;
    }
}
