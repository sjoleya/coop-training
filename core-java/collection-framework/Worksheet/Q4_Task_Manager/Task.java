package Worksheet.Q4_Task_Manager;

import java.time.LocalDate;

class Task {
    String taskName;
    int priority;
    LocalDate deadline;

    public Task() {
    }

    public Task(String taskName, int priority, LocalDate deadline) {
        this.taskName = taskName;
        this.priority = priority;
        this.deadline = deadline;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Task Name: " + this.getTaskName()
                + ", Priority: " + this.getPriority()
                + ", Deadline: " + this.getDeadline();
    }
}