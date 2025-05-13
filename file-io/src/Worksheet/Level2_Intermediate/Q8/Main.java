package Worksheet.Level2_Intermediate.Q8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Write a program to read a CSV file named employees.csv and print each line in uppercase.
 */

public class Main {
    public static void main(String[] args) {
        String filePath = "src/Worksheet/Level2_Intermediate/Q8/employees.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line.toUpperCase());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}