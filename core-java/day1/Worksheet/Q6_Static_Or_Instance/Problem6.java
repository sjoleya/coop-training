package Worksheet.Q6_Static_Or_Instance;

/*
Create a `Student` class with a static counter to track total students. Each student has a unique ID
and name. Display the total number of students after creating multiple objects
 */

class Student {
    private static int studentCount = 0;
    private int studentID;
    private String name;

    public Student(String name) {
        studentCount++;
        this.studentID = studentCount;   // Assign unique ID based on counter
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Student ID: " + studentID + ", Name: " + name);
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + studentCount);
    }
}

// Main class
public class Problem6 {
    public static void main(String[] args) {
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");

        s1.displayInfo();
        s2.displayInfo();
        s3.displayInfo();

        Student.displayTotalStudents();
    }
}