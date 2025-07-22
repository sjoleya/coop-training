package Worksheet.Q8_Employee_Hierarchy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Manager, TreeMap<Integer, List<Employee>>> hierarchy = new HashMap<>();

        Manager alice = new Manager("Alice");
        Manager bob = new Manager("Bob");

        addEmployee(hierarchy, alice, 1, new Employee("John"));
        addEmployee(hierarchy, alice, 2, new Employee("Derek"));
        addEmployee(hierarchy, alice, 2, new Employee("Lucy"));
        addEmployee(hierarchy, alice, 3, new Employee("Karl"));

        addEmployee(hierarchy, bob, 1, new Employee("Nina"));
        addEmployee(hierarchy, bob, 1, new Employee("Sam"));
        addEmployee(hierarchy, bob, 2, new Employee("Zara"));

        for (Map.Entry<Manager, TreeMap<Integer, List<Employee>>> entry : hierarchy.entrySet()) {
            Manager manager = entry.getKey();
            System.out.println("Manager: " + manager.getName());
            TreeMap<Integer, List<Employee>> levelMap = entry.getValue();
            for (Map.Entry<Integer, List<Employee>> levelEntry : levelMap.entrySet()) {
                System.out.println("  Level " + levelEntry.getKey() + ": " + levelEntry.getValue());
            }
        }
    }

    private static void addEmployee(Map<Manager, TreeMap<Integer, List<Employee>>> map,
            Manager manager, int level, Employee employee) {
        map.computeIfAbsent(manager, _ -> new TreeMap<>())
                .computeIfAbsent(level, _ -> new ArrayList<>())
                .add(employee);
    }
}
