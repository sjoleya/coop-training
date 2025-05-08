package Worksheet.Q1_Student_Management;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

/*
Problem 1: Advanced Student Management (List, Comparator, Map)

Create a Student class with id, name, age, grade, and branch.
•	Store at least 15 students in an ArrayList.
•	Sort students by branch, then by descending grade.
•	Group students by branch using a Map<String, List<Student>>.
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1, "Alice", 20, 3.5, "CS"));
        students.add(new Student(2, "Bob", 21, 3.0, "EE"));
        students.add(new Student(3, "Charlie", 22, 2.0, "ME"));
        students.add(new Student(4, "Diana", 20, 3.0, "CS"));
        students.add(new Student(5, "Ethan", 23, 4.0, "EE"));
        students.add(new Student(6, "Fiona", 21, 1.0, "ME"));
        students.add(new Student(7, "George", 22, 0.0, "CS"));
        students.add(new Student(8, "Hannah", 20, 2.0, "EE"));
        students.add(new Student(9, "Ian", 21, 3.0, "ME"));
        students.add(new Student(10, "Jill", 23, 4.0, "CS"));

        students.sort(
                Comparator.comparing(Student::getBranch)
                        .thenComparing(Student::getGrade));
        students.forEach(System.out::println);

        Map<String, List<Student>> groupByBranch = students.stream()
                .collect(groupingBy(Student::getBranch));

        groupByBranch.forEach((branch, list) -> {
            System.out.println("\nBranch: " + branch);
            list.forEach(s -> System.out.println("  " + s.name + " (" + s.grade + ")"));
        });
    }
}
