package Worksheet.Q10_Bank_Transaction_Logs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Transaction {
    private final LocalDateTime time;
    private final double amount;
    private final String description;

    public Transaction(LocalDateTime time, double amount, String description) {
        this.time = time;
        this.amount = amount;
        this.description = description;
    }

    public LocalDateTime getTime() { return time; }
    public double getAmount() { return amount; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return time.format(formatter) + " | " + amount + " | " + description;
    }
}

