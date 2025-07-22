package Worksheet.Q8_Employee_Hierarchy;

public class Employee {
    private static int idCounter;
    int id;
    String name;

    public Employee(String name) {
        this.name = name;
        this.id = idCounter++;
    }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Employee ID: " + id + "Name: " + name;
    }
}
