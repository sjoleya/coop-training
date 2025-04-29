package Worksheet.Q5_Abstraction;

/*
Create an abstract class `Employee` with abstract methods `calculateSalary()` and `getDetails()`.
Extend it with `FullTimeEmployee` and `Freelancer` classes, each with their own salary calculation
logic.
 */

abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();
    public abstract String getDetails();
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public String getDetails() {
        return "Full-Time Employee: " + name + ", Monthly Salary: ₹" + monthlySalary;
    }
}

class Freelancer extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public Freelancer(String name, double hourlyRate, int hoursWorked) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String getDetails() {
        return "Freelancer: " + name + ", Hourly Rate: ₹" + hourlyRate +
                ", Hours Worked: " + hoursWorked +
                ", Total Salary: ₹" + calculateSalary();
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Employee emp1 = new FullTimeEmployee("Alice", 5000);
        Employee emp2 = new Freelancer("Bob", 40, 120);

        System.out.println(emp1.getDetails());
        System.out.println("Full Time Employee Salary: ₹" + emp1.calculateSalary());

        System.out.println(emp2.getDetails());
        System.out.println("Freelancer Salary: ₹" + emp2.calculateSalary());
    }
}
