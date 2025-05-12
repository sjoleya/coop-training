package FP_Assignment.Level9_Collectors_and_Summarizations.EmployeeDataAnalyzer;

import java.time.Year;

public class Employee {
    private String name;
    private double salary;
    private Year joiningYear;

    public Employee(String name, double salary, Year joiningYear) {
        this.name = name;
        this.salary = salary;
        this.joiningYear = joiningYear;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Year getJoiningYear() {
        return joiningYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", joiningYear=" + joiningYear +
                '}';
    }
}