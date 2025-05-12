package FP_Assignment.Level9_Collectors_and_Summarizations.EmployeeDataAnalyzer;

import java.time.Year;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Write a program that groups a list of employees by joining year, and then finds the max salary in each year.
 */

public class EmployeeGrouper {

    public static Map<Year, Double> findMaxSalaryByJoiningYear(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getJoiningYear,
                        Collectors.mapping(Employee::getSalary, Collectors.maxBy(Double::compare))))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().orElse(0.0)));
    }

    public static void main(String[] args) {
        List<Employee> employeeList = List.of(
                new Employee("Alice", 50000, Year.of(2020)),
                new Employee("Bob", 60000, Year.of(2021)),
                new Employee("Charlie", 70000, Year.of(2020)),
                new Employee("David", 80000, Year.of(2021)));

        Map<Year, Double> maxSalaryByYear = findMaxSalaryByJoiningYear(employeeList);
        System.out.println("Max Salary by Joining Year: " + maxSalaryByYear);
    }
}