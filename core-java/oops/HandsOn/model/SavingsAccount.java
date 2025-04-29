package HandsOn.model;

public class SavingsAccount extends BankAccount {
    @Override
    public String getAccountType() {
        return "Savings";
    }
    public SavingsAccount(String accNumber, int balance) {
        super(accNumber, balance);
    }
}
