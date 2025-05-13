package Worksheet.Level3_Advanced.Q12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.io.FileWriter;

/*
 * Write a program to merge all the text files in the current directory into a single file called merged.txt.
 */

public class Main {

    public static void main(String[] args) {
        String folderPath = "src/Worksheet/Level3_Advanced/Q12/files"; // Current directory
        String outputFile = "src/Worksheet/Level3_Advanced/Q12/merged.txt";

        try {
            List<Path> textFiles = Files.list(Paths.get(folderPath))
                    .filter(file -> file.toString().endsWith(".txt"))
                    .collect(Collectors.toList());

            try (FileWriter writer = new FileWriter(outputFile)) {
                for (Path file : textFiles) {
                    List<String> lines = Files.readAllLines(file);
                    for (String line : lines) {
                        writer.write(line + System.lineSeparator());
                    }
                }
            }

            System.out.println("Successfully merged text files into " + outputFile);

        } catch (IOException e) {
            System.err.println("Error merging files: " + e.getMessage());
        }
    }
}
