package Worksheet.Level1_Basic.Q3;

import java.io.File;

/*
 * Write a program that checks if a file named report.pdf exists in the current directory and prints its size (in bytes).
 */

public class Main {
    public static void main(String[] args) {
        String path = "src/Worksheet/Level1_Basic/Q3/";
        try {
            File file = new File(path + "report.pdf");

            if (file.exists()) {
                System.out.println("File size: " + file.length() + " bytes");
            } else {
                System.out.println("File does not exist");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}