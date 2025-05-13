package Worksheet.Level1_Basic.Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Write a program to read and print the contents of a file named input.txt.
 */

public class Main {
    public static void main(String[] args) {
        String path = "src/Worksheet/Level1_Basic/Q2/";
        String filePath = path + "input.txt";
        try {
            File inputFile = new File(filePath);
            Scanner Reader = new Scanner(inputFile);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                System.out.println(data);
            }
            Reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("input.txt Not Found");
            e.printStackTrace();
        }
    }
}
