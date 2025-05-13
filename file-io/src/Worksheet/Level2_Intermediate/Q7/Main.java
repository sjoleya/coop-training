package Worksheet.Level2_Intermediate.Q7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/*
 * Write a program that appends the line "Last updated on [current date]" to an existing file log.txt.
 */

public class Main {
    public static void main(String[] args) {
        String filePath = "src/Worksheet/Level2_Intermediate/Q7/log.txt";

        Date date = new Date();
        String message = "Last updated on " + date;

        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write("\n" + message + "\n");
            System.out.println("Successfully appended to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
