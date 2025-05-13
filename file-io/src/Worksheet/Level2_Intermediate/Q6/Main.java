package Worksheet.Level2_Intermediate.Q6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Write a program to read all the words from paragraph.txt and count how many times the word "Java" appears.
 */

public class Main {
    public static void main(String[] args) {
        String filePath = "src/Worksheet/Level2_Intermediate/Q6/paragraph.txt";
        String searchWord = "Java";
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(searchWord)) {
                        count++;
                    }
                }
            }
            System.out.println("The word \"" + searchWord + "\" appears " + count + " times.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
