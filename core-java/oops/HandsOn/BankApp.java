package HandsOn;

import HandsOn.model.BankAccount;
import HandsOn.model.CurrentAccount;
import HandsOn.model.SavingsAccount;
import HandsOn.service.StandardDeposit;
import HandsOn.service.StandardWithdraw;

import java.util.Scanner;

public class BankApp {
    private static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        BankAccount account;

        System.out.println("=== Welcome to the Bank CLI ===");
        System.out.print("Enter account number: ");
        String accNumber = scanner.nextLine();

        System.out.print("Select account type (1. Savings  2. Current): ");
        int type = scanner.nextInt();

        if (type == 1) {
            account = new SavingsAccount(accNumber, 0);
        } else if (type == 2) {
            account = new CurrentAccount(accNumber, 0);
        } else {
            System.out.println("Invalid account type.");
            scanner.close();
            return;
        }

        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Show Balance\n4. Show Account Type\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleDeposit(account);
                    break;
                case 2:
                    handleWithdraw(account);
                    break;
                case 3:
                    showBalance(account);
                    break;
                case 4:
                    showAccountType(account);
                    break;
                case 5:
                    System.out.println("Thank you for using the Bank CLI!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void handleDeposit(BankAccount account) {
        System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        if (depositAmount < 0) {
            System.err.println("Please Enter Valid Amount to Deposit!");
            return;
        }
        StandardDeposit.deposit(account, depositAmount);
        System.out.println("Deposited ₹" + depositAmount + " using StandardDeposit.");
    }

    private static void handleWithdraw(BankAccount account) {
        System.out.print("Enter withdraw amount: ");
        double withdrawAmount = scanner.nextDouble();
        if (withdrawAmount < 0) {
            System.err.println("Please Enter Valid Amount to Withdraw!");
            return;
        }
        if (account.balance < withdrawAmount) {
            System.err.println("Insufficient Balance!");
            return;
        }
        StandardWithdraw.withdraw(account, withdrawAmount);
        System.out.println("Withdrawn ₹" + withdrawAmount + " using StandardWithdraw.");
    }

    private static void showBalance(BankAccount account) {
        System.out.println("Account Balance is: ₹" + account.getBalance());
    }

    private static void showAccountType(BankAccount account) {
        System.out.println("Account Type is: " + account.getAccountType());
    }
}
