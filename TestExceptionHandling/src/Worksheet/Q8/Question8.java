package Worksheet.Q8;

import java.io.IOException;

/*
 * 8. Implement a programmatic exception handling policy: write a method that attempts to read from a flaky service 3 times. 
 * If it fails all 3 times, it throws a `ServiceUnavailableException`.
 */

public class Question8 {

    public static void main(String[] args) {
        try {
            String data = readFromFlakyService();
            success(data);
        } catch (ServiceUnavailableException e) {
            System.err.println("Service unavailable: " + e.getMessage());
        }
    }

    static String readFromFlakyService() throws ServiceUnavailableException {
        int attempts = 0;
        while (attempts < 3) {
            try {
                attempts++;
                // Simulate a flaky service
                if (Math.random() > 0.3) {
                    throw new IOException("Service temporarily unavailable");
                }
                return "Data from service"; // Success
            } catch (IOException e) {
                System.err.println("Attempt " + attempts + " failed: " + e.getMessage());
            }
        }
        throw new ServiceUnavailableException("Service unavailable after 3 attempts");
    }

    static void success(String result) {
        System.out.println("Service call succeeded with result: " + result);
    }
}