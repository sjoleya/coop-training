package HandsOn.repo;

import HandsOn.model.Student;

import java.util.*;

public class StudentRepository {
    private static Map<String, Student> studentMap = new HashMap<>();

    public StudentRepository() {
        studentMap.put("S101", new Student("S101", "Aarav", "aarav@example.com", 1, "CSE"));
        studentMap.put("S102", new Student("S102", "Isha", "isha@example.com", 2, "ECE"));
        studentMap.put("S103", new Student("S103", "Rohan", "rohan@example.com", 3, "ME"));
        studentMap.put("S104", new Student("S104", "Sneha", "sneha@example.com", 2, "IT"));
        studentMap.put("S105", new Student("S105", "Vikram", "vikram@example.com", 1, "EEE"));
    }

    public void save(Student student) {
        studentMap.put(student.getId(), student);
    }

    public Optional<Student> getById(String studentId) {
        return Optional.ofNullable(studentMap.get(studentId));
    }

    public List<Student> getAll() {
        return new ArrayList<>(studentMap.values());
    }

    public void update(Student student) {
        studentMap.put(student.getId(), student);
    }

    public void delete(String id) {
        studentMap.remove(id);
    }
}
