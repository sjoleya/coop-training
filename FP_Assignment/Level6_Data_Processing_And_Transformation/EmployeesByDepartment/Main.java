package FP_Assignment.Level6_Data_Processing_And_Transformation.EmployeesByDepartment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Sales"),
                new Employee("Bob", "Marketing"),
                new Employee("Charlie", "Sales"),
                new Employee("David", "IT"),
                new Employee("Eve", "Marketing"));

        Map<String, Long> employeeCountsByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        System.out.println("Employee counts by department: " + employeeCountsByDepartment);
    }
}