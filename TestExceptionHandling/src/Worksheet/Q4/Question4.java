package Worksheet.Q4;

import java.io.IOException;

/*
 * 4. Write a method that catches an exception and re-throws it wrapped inside a new exception with a custom message, 
 * preserving the original stack trace (`throw new CustomException("message", e)`). 
 */

public class Question4 {

    public static void main(String[] args) {
        try {
            RiskyOperation();
        } catch (CustomException e) {
            System.err.println("Caught exception: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Original exception: " + e.getCause().getMessage());
            }
        }
    }

    static void RiskyOperation() throws CustomException {
        try {
            Thread.sleep(1000); // Simulate an IO exception
            throw new IOException("Simulated IO error");
        } catch (IOException | InterruptedException e) {
            throw new CustomException("Error during risky operation", e);
        }
    }
}