package Worksheet.Q3_Odd_Even_Printer;

public class SharedPrinter {
    private int number = 1;
    private final int MAX = 100;
    private boolean isOddTurn = true;

    synchronized void printOdd() {
        if (number > MAX) {
            notifyAll();
            return;
        }
        while (!isOddTurn && number <= MAX) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        if (number <= MAX) {
            System.out.println("Odd Thread: " + number);
            number++;
            isOddTurn = false;
            notifyAll();
        }
    }

    synchronized void printEven() {
        if (number > MAX) {
            notifyAll();
            return;
        }
        while (isOddTurn && number <= MAX) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        if (number <= MAX) {
            System.out.println("Even Thread: " + number);
            number++;
            isOddTurn = true;
            notifyAll();
        }
    }

    synchronized boolean isCompleted() {
        return number > MAX;
    }
}