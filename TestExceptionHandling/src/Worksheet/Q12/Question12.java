package Worksheet.Q12;

/*
 * 12. Global exception handler
 * Write a Java application where all uncaught exceptions are logged by setting a global exception handler 
 * (using `Thread.setDefaultUncaughtExceptionHandler()`).
 */

public class Question12 {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {
            System.err.println(
                    "Global uncaught exception handler: " + exception.getMessage() + " in thread " + thread.getName());
        });

        // Simulate an uncaught exception
        throw new NullPointerException("Simulated uncaught exception");
    }
}