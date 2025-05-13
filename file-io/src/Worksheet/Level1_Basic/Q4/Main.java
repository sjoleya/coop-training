package Worksheet.Level1_Basic.Q4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Write a program to count the number of lines in a text file called data.txt.
 */

public class Main {
    public static void main(String[] args) {
        String path = "src/Worksheet/Level1_Basic/Q4/";
        File file = new File(path + "data.txt");
        int lineCount = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lineCount++;
            }
            System.out.println("Number of lines: " + lineCount);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}