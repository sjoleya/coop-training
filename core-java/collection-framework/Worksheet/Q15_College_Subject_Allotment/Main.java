package Worksheet.Q15_College_Subject_Allotment;

import java.util.*;

/*
Problem 15: College Subject Allotment (Map<String, List<String>>)
•	Store which subjects are allotted to each student
•	Provide reverse lookup: which students chose a specific subject
 */

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> studentSubjects = new HashMap<>();
        studentSubjects.put("nikhil", Arrays.asList("physics", "chemistry", "biology"));
        studentSubjects.put("sudhanshu", Arrays.asList("physics", "chemistry", "maths"));
        studentSubjects.put("saloni", Arrays.asList("commerce", "ip"));
        studentSubjects.put("raj", Arrays.asList("commerce", "maths"));

        System.out.println("\nSubject Allotments:");
        for (Map.Entry<String, List<String>> entry : studentSubjects.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        String subjectToFind = "chemistry";
        List<String> studentsForSubject = reverseLookup(studentSubjects, subjectToFind);

        System.out.println("\nStudents who chose " + subjectToFind + ":");
        for (String student : studentsForSubject) {
            System.out.println(student);
        }

    }

    // Reverse lookup method
    public static List<String> reverseLookup(Map<String, List<String>> studentSubjects, String subject) {
        List<String> students = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : studentSubjects.entrySet()) {
            if (entry.getValue().contains(subject)) {
                students.add(entry.getKey());
            }
        }
        return students;
    }
}
