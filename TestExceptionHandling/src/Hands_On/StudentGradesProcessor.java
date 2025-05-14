package Hands_On;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentGradesProcessor {

    public static void main(String[] args) {
        String filePath = "src/Hands_On/grades.txt";
        List<String> validEntries = new ArrayList<>();
        List<String> failingStudents = new ArrayList<>();
        double totalGrade = 0;
        int validCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length != 2) {
                    System.out.println("Warning: Invalid format in line - " + line);
                    continue;
                }

                String studentName = parts[0];
                String gradeStr = parts[1];

                try {
                    int grade = Integer.parseInt(gradeStr);
                    if (grade < 0 || grade > 100) {
                        throw new InvalidGradeException("Grade out of range: " + grade);
                    }

                    validEntries.add(studentName + " " + grade);
                    totalGrade += grade;
                    validCount++;

                    if (grade < 40) {
                        failingStudents.add(studentName);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Warning: Non-numeric grade for " + studentName);
                } catch (InvalidGradeException e) {
                    System.out.println("Warning: " + e.getMessage() + " for " + studentName);
                }
            }

            if (validCount > 0) {
                double averageGrade = totalGrade / validCount;
                System.out.println("\n--- Results ---");
                System.out.println("Valid Student Grades:");
                for (String entry : validEntries) {
                    System.out.println(entry);
                }
                System.out.println("\nFailing Students:");
                for (String student : failingStudents) {
                    System.out.println(student);
                }
                System.out.println("\nAverage Grade: " + averageGrade);
            } else {
                System.out.println("No valid grades found in the file.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filePath);
        } catch (IOException e) {
            System.out.println("Error: Could not read file - " + filePath);
        } finally {
            System.out.println("Processing complete.");
        }
    }
}