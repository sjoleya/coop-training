package FP_Assignment.Level6_Data_Processing_And_Transformation.AverageSalaryByDepartment;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "Sales", 50000.0),
                new Employee("Bob", "Marketing", 60000.0),
                new Employee("Charlie", "Sales", 55000.0),
                new Employee("David", "IT", 70000.0),
                new Employee("Eve", "Marketing", 65000.0));

        Map<String, Double> averageSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("Average salary by department: " + averageSalaryByDepartment);
    }
}