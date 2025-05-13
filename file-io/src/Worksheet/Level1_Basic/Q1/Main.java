package Worksheet.Level1_Basic.Q1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Write a program to create a new text file named notes.txt and write the line:
 * "This is my first file in Java."
 */

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "src/Worksheet/Level1_Basic/Q1/";
        File file = new File(path + "notes.txt");

        String data = "This is my first file in Java";
        if (!file.exists()) {
            file.createNewFile();
        }
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(data);
            System.out.println("Data printed successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
