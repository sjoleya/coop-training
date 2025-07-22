package Worksheet.Q3_Odd_Even_Printer;

/*
Assignment 3: Odd-Even Printer
Background:
Create a coordinated printing system where two threads print odd and even numbers up to 100 in sequence.
Requirements:
Thread A prints odd numbers (1, 3, 5...)
Thread B prints even numbers (2, 4, 6...)
Output must be in order: 1 2 3 4 5 ... 100
Use wait() and notify() for coordination
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedPrinter printer = new SharedPrinter();

        Thread ThreadA = new Thread(() -> {
            while(!printer.isCompleted()) {
                printer.printOdd();
            }
        });

        Thread ThreadB = new Thread(() -> {
            while (!printer.isCompleted()) {
                printer.printEven();
            }
        });

        ThreadA.start();
        ThreadB.start();

        ThreadA.join();
        ThreadB.join();
    }
}
