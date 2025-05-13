package Worksheet.Level3_Advanced.Q15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * Write a program that reads a text file and counts the frequency of each character (including spaces and punctuation).
 * Print the result to a file named charcount.txt.
 */

public class Main {

    public static void main(String[] args) {
        String inputFile = "src/Worksheet/Level3_Advanced/Q15/input.txt";
        String outputFile = "src/Worksheet/Level3_Advanced/Q15/charCount.txt";

        Map<Character, Integer> charCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int character;
            while ((character = reader.read()) != -1) {
                char ch = (char) character;
                charCounts.put(ch, charCounts.getOrDefault(ch, 0) + 1);
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
            return;
        }

        try (FileWriter writer = new FileWriter(outputFile)) {
            for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Error writing to output file: " + e.getMessage());
        }

        System.out.println("Character counts written to " + outputFile);
    }
}
