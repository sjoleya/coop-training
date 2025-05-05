package Worksheet.Q3_Department_Directory;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

/*
Problem 3: Department Directory with Sorted Employees (Map, List)
Maintain a Map<String, List<Employee>> where the key is department name.
•	Sort each department’s employees by salary descending.
•	Provide a method to return top N paid employees across all departments.
 */

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Alice Johnson", "HR", 55000));
        employees.add(new Employee(102, "Bob Smith", "IT", 72000));
        employees.add(new Employee(103, "Charlie Brown", "Finance", 68000));
        employees.add(new Employee(104, "Diana Prince", "IT", 80000));
        employees.add(new Employee(105, "Ethan Hunt", "Marketing", 60000));
        employees.add(new Employee(106, "Fiona Gallagher", "HR", 57000));
        employees.add(new Employee(107, "George Bailey", "Finance", 69000));
        employees.add(new Employee(108, "Hannah Wells", "Marketing", 61000));
        employees.add(new Employee(109, "Ian Malcolm", "IT", 75000));
        employees.add(new Employee(110, "Julia Roberts", "HR", 59000));

        Map<String, List<Employee>> groupByDepartment = employees.stream()
                .collect(groupingBy(Employee::getDepartment));

        for (Map.Entry<String, List<Employee>> entry : groupByDepartment.entrySet()) {
            System.out.println("\nDepartment: " + entry.getKey());
            List<Employee> employeeList = entry.getValue();
            employeeList.sort((e1, e2) -> Integer.compare(e2.salary, e1.salary));
            for (Employee employee : employeeList) {
                System.out.println(employee.name + " - $" + employee.salary);
            }
        }
        // @TODO:
    }
}
