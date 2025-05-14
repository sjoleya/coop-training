package Worksheet.Q6;

import java.io.File;

/*
 * 6. Custom checked vs unchecked exceptions
 *    Define a custom checked exception (FileValidationException) and a runtime exception (CriticalSystemException)
 */

public class Question6 {

    public static void main(String[] args) {
        try {
            validateFile(new File("src/Worksheet/Q6/input.txt"));
        } catch (FileValidationException e) {
            System.err.println("File validation failed: " + e.getMessage());
        }

        try {
            startCriticalService();
        } catch (CriticalSystemException e) {
            System.err.println("Critical service failed to start: " + e.getMessage());
        }
    }

    static void validateFile(File file) throws FileValidationException {
        if (!file.exists()) {
            throw new FileValidationException("File does not exist");
        }
        System.out.println("File validated successfully.");
    }

    static void startCriticalService() {
        // Simulate a critical system failure
        throw new CriticalSystemException("Failed to acquire essential resource");
    }
}