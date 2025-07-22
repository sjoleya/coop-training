package Worksheet.Q2_Bank_Account_Synchronisation;

import java.util.Date;
import java.text.SimpleDateFormat;

class Transaction {
    private final String timestamp;
    private final String threadName;
    private final String accountId;
    private final String type; // "DEPOSIT", "WITHDRAWAL_SUCCESS", "WITHDRAWAL_FAIL"
    private final double amount;
    private final double balanceAfter;

    public Transaction(String threadName, String accountId, String type, double amount, double balanceAfter) {
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        this.threadName = threadName;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    @Override
    public String toString() {
        return String.format("[%s] Thr-%s | Acc-%s | %-18s | Amt: %8.2f | Bal: %10.2f",
                timestamp, threadName, accountId, type, amount, balanceAfter);
    }
}