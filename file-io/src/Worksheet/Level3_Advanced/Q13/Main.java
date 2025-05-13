package Worksheet.Level3_Advanced.Q13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Write a program to read the server.log file and print all the lines that contain the word "ERROR".
 */

public class Main {

    public static void main(String[] args) {
        String logFile = "src/Worksheet/Level3_Advanced/Q13/server.log";
        String searchTerm = "ERROR";

        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchTerm)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
        }
    }
}