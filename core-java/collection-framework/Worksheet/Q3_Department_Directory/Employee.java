package Worksheet.Q3_Department_Directory;

public class Employee {
    long id;
    String name;
    String department;
    int salary;

    public Employee(long id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    String getDepartment() {
        return this.department;
    }
}
