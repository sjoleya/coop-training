package Worksheet.Q4_Task_Manager;

import java.time.LocalDate;
import java.util.*;

/*
Problem 4: Task Prioritization Engine (PriorityQueue, Comparator)
Create a Task class with name, priority, deadline.
•	Use PriorityQueue  to order by closest deadline, then highest priority.
•	Poll and print tasks as they should be executed.
 */

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(
                Comparator.comparing(Task::getDeadline)
                        .thenComparing(Comparator.comparingInt(Task::getPriority).reversed()));

        taskQueue.add(new Task("Task 1", 2, LocalDate.of(2025, 10, 15)));
        taskQueue.add(new Task("Task 2", 1, LocalDate.of(2025, 10, 10)));
        taskQueue.add(new Task("Task 3", 3, LocalDate.of(2025, 10, 20)));
        taskQueue.add(new Task("Task 4", 2, LocalDate.of(2025, 10, 12)));
        taskQueue.add(new Task("Task 5", 1, LocalDate.of(2025, 10, 18)));
        taskQueue.add(new Task("Task 6", 3, LocalDate.of(2025, 10, 25)));

        System.out.println("\nTasks sorted by deadline and priority:");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println(task);
        }
    }
}
