package HandsOn.repo;

import java.util.*;

import HandsOn.model.Course;

public class CourseRepository {
    private static Map<String, Course> courseMap = new HashMap<>();

    public CourseRepository() {
        courseMap.put("CS101", new Course("CS101", "Data Structures",
                "Introduction to data organization and algorithms", "Prof. Rao", 2, 4));
        courseMap.put("EE201",
                new Course("EE201", "Circuits", "Basics of electrical circuits and analysis", "Dr. Mehta", 1, 3));

    }

    public void save(Course course) {
        courseMap.put(course.getId(), course);
    }

    public Optional<Course> getById(String courseId) {
        return Optional.ofNullable(courseMap.get(courseId));
    }

    public List<Course> getAll() {
        return new ArrayList<>(courseMap.values());
    }

    public void update(Course course) {
        courseMap.put(course.getId(), course);
    }

    public void delete(String id) {
        courseMap.remove(id);
    }
}
