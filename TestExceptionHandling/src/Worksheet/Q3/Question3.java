package Worksheet.Q3;

import java.io.*;

/*
 * 3. Write a program that opens two files (`BufferedReader` and `BufferedWriter`), reads from one, and writes to the other.
 *    Use `try-with-resources` to ensure both are closed safely, even if exceptions occur in the middle.
 */

public class Question3 {

    public static void main(String[] args) {
        String path = "src/Worksheet/Q3/";
        try {
            copyFile(path + "input.txt", path + "output.txt");
            System.out.println("Contents Copied successfully!");
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }

    static void copyFile(String source, String destination) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}