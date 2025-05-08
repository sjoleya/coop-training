package Worksheet.Q1_Student_Management;

class Student {
    long id;
    String name;
    int age;
    double grade;
    String branch;

    Student(long id, String name, int age, double grade, String branch) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.branch = branch;
    }

    String getBranch() {
        return this.branch;
    }

    double getGrade() {
        return this.grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", branch='" + branch + '\'' +
                '}';
    }
}