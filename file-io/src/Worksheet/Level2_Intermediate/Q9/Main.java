package Worksheet.Level2_Intermediate.Q9;

import java.io.File;

/*
 * Write a program to delete a file named oldfile.txt if it exists.
 */

public class Main {
    public static void main(String[] args) {
        String filePath = "src/Worksheet/Level2_Intermediate/Q9/oldFile.txt";

        File file = new File(filePath);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }
}