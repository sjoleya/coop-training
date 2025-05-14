package Worksheet.Q11;

/*
 *  11. Thread exception handling
 *      Write a multithreaded program where a child thread throws a `RuntimeException`.
 *      Show how the main thread can detect and handle that exception using `Thread.setUncaughtExceptionHandler()`.
 */

public class Question11 {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {
            System.err.println("Uncaught exception in thread " + thread.getName() + ": " + exception.getMessage());
        });

        Thread childThread = new Thread(() -> {
            throw new RuntimeException("Exception from child thread");
        });

        childThread.start();
    }
}