package Worksheet.Level3_Advanced.Q11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Write a program to copy the contents of image.jpg to a new file called image_copy.jpg.
 */

public class Main {

    public static void main(String[] args) {
        String sourceFile = "src/Worksheet/Level3_Advanced/Q11/image.jpg";
        String destinationFile = "src/Worksheet/Level3_Advanced/Q11/image_copy.jpg";

        try (FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}
