package HandsOn.service;

import java.util.List;

import HandsOn.model.Course;

public interface CourseService {
    void save(Course course);

    Course getById(String id);

    List<Course> getAll();

    void update(Course course);

    void delete(String id);

    List<Course> getCoursesSortedByEnrollments();

    List<Course> getCoursesFilteredByInstructor(String instructorName);

    List<Course> getCoursesFilteredByCredits(int credits);
}
