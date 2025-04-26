package HandsOn.Models;

public class CurrentAccount extends BankAccount {
    @Override
    public String getAccountType() {
        return "Current";
    }
    public CurrentAccount(String accNumber, int balance) {
        super(accNumber, balance);
    }
}
