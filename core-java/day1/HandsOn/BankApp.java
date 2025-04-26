package HandsOn;

import HandsOn.Models.BankAccount;
import HandsOn.Models.CurrentAccount;
import HandsOn.Models.SavingsAccount;
import HandsOn.Services.StandardDeposit;
import HandsOn.Services.StandardWithdraw;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;
        System.out.println("=== Welcome to the Bank CLI ===");
        System.out.print("Enter account number: ");
        String accNumber = sc.nextLine();
        System.out.print("Select account type (1. Savings  2. Current): ");
        int type = sc.nextInt();

        if (type == 1) {
            account = new SavingsAccount(accNumber, 0);
        } else if (type == 2) {
            account = new CurrentAccount(accNumber, 0);
        } else {
            System.out.println("Invalid account type.");
            sc.close();
            return;
        }
        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Show Balance\n4. Show Account Type\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    if(depositAmount < 0) {
                        System.err.println("Please Enter Valid Amount to Deposit!");
                        break;
                    }
                    StandardDeposit.deposit(account, depositAmount);
                    System.out.println("Deposited ₹" + depositAmount + " using StandardDeposit.");
                    break;
                case 2:
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = sc.nextDouble();
                    if(withdrawAmount < 0) {
                        System.err.println("Please Enter Valid Amount to Withdraw!");
                        break;
                    }
                    if(account.balance < withdrawAmount) {
                        System.err.println("Insufficient Balance!");
                        break;
                    }
                    StandardWithdraw.withdraw(account, withdrawAmount);
                    System.out.println("Withdrawn ₹" + withdrawAmount + " using StandardWithdraw.");
                    break;
                case 3:
                    System.out.println("Account Balance is: ₹" + account.getBalance());
                    break;
                    case 4:
                    System.out.println("Account Type is: " + account.getAccountType());
                    break;
                    case 5:
                    System.out.println("Thank you for using the Bank CLI!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
