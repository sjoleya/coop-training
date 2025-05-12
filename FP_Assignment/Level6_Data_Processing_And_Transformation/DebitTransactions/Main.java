package FP_Assignment.Level6_Data_Processing_And_Transformation.DebitTransactions;

import java.util.Arrays;
import java.util.List;

/*
 * Given a list of transactions (with amount and type), 
 * calculate the total amount for type "DEBIT" using streams.
 */

public class Main {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("DEBIT", 100.0),
                new Transaction("CREDIT", 50.0),
                new Transaction("DEBIT", 200.0),
                new Transaction("DEBIT", 50.0),
                new Transaction("CREDIT", 100.0));

        double totalDebit = transactions.stream()
                .filter(transaction -> transaction.getType().equals("DEBIT"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        System.out.println("Total DEBIT amount: " + totalDebit);
    }
}