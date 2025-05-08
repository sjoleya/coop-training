package Worksheet.Q2_Bank_Account_Synchronisation;

import java.util.Random;

class UserAction implements Runnable {
    private final BankAccount account;
    private final int numOperations;
    private final Random random = new Random();

    public UserAction(BankAccount account, int numOperations) {
        this.account = account;
        this.numOperations = numOperations;
    }

    @Override
    public void run() {
        for (int i = 0; i < numOperations; i++) {
            boolean doDeposit = random.nextBoolean();
            double amount = (random.nextInt(100) + 1) * 10.0; // Amount between 10 and 1000

            if (doDeposit) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }

            try {
                // Simulate some time between operations
                Thread.sleep(random.nextInt(50) + 20); // 20-70 ms
            } catch (InterruptedException e) {
                System.err.println("Thread " + Thread.currentThread().getName() + " interrupted.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
