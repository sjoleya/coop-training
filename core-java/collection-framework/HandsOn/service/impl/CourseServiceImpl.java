package HandsOn.service.impl;

import java.util.List;

import HandsOn.exceptions.CourseNotFoundException;
import HandsOn.model.Course;
import HandsOn.repo.CourseRepository;
import HandsOn.service.CourseService;

public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository = new CourseRepository();

    @Override
    public void save(Course course) {
        // TODO: Add Validations
        courseRepository.save(course);
    }

    @Override
    public Course getById(String id) {
        return courseRepository.getById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found!"));

    }

    @Override
    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    @Override
    public void update(Course course) {
        courseRepository.update(course);
    }

    @Override
    public void delete(String id) {
        courseRepository.delete(id);
    }

    @Override
    public List<Course> getCoursesSortedByEnrollments() {
        List<Course> courses = getAll();
        courses.sort((course1, course2) -> Integer.compare(course2.getEnrolledStudents().size(),
                course1.getEnrolledStudents().size()));
        return courses;
    }

    @Override
    public List<Course> getCoursesFilteredByInstructor(String instructorName) {
        return getAll().stream().filter(course -> course.getInstructorName().equalsIgnoreCase(instructorName)).toList();
    }

    @Override
    public List<Course> getCoursesFilteredByCredits(int credits) {
        List<Course> courses = getAll();
        return courses.stream().filter(course -> course.getCredits() == credits).toList();
    }

}
