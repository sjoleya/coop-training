package Worksheet.Q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * 1. Write a program with three methods: `readData()`, `processData()`, and `main()`.
    - `readData()` reads from a file and throws `IOException`.
    - `processData()` calls `readData()` and catches `IOException`, then throws a `DataProcessingException` (custom).
    - `main()` catches `DataProcessingException` and logs it.
    Simulate this flow and explain how exceptions travel across layers.
 */

public class Question1 {

    private static final Logger LOGGER = Logger.getLogger(Question1.class.getName());

    public static void main(String[] args) {
        try {
            processData();
        }
        catch (DataProcessingException e) {
            LOGGER.log(Level.SEVERE, "Error processing data: ", e);
        }
    }

    static void processData() throws DataProcessingException {
        try {
            readData();
        } catch (IOException e) {
            throw new DataProcessingException("Failed to process data due to IO error", e);
        }
    }

    static void readData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Worksheet/Q1/data.txt"))) {
            String line = reader.readLine();
            if (line == null) {
                throw new IOException("End of file reached");
            }
            System.out.println("Read data: " + line);
        }
    }
}