package Worksheet.Level1_Basic.Q5;

import java.io.*;

/*
 * Write a program that copies the contents of source.txt to a new file called backup.txt.
 */

public class Main {
    public static void main(String[] args) {
        String path = "src/Worksheet/Level1_Basic/Q5/";
        File source = new File(path + "source.txt");
        File backup = new File(path + "backup.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(source));
                BufferedWriter writer = new BufferedWriter(new FileWriter(backup))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File copied successfully");
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
}
