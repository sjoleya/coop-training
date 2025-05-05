package HandsOn.service.impl;

import java.util.*;

import HandsOn.exceptions.CourseNotFoundException;
import HandsOn.exceptions.DuplicateEntryException;
import HandsOn.exceptions.StudentNotFoundException;
import HandsOn.model.Course;
import HandsOn.model.Student;
import HandsOn.service.interfaces.CourseService;
import HandsOn.service.interfaces.RegistrationService;
import HandsOn.service.interfaces.StudentService;

public class RegistrationServiceImpl implements RegistrationService {

    private final CourseService courseService;
    private final StudentService studentService;

    public RegistrationServiceImpl(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Override
    public String registerStudentToCourse(String studentId, String courseId) {
        Student student = studentService.getById(studentId);
        Course course = courseService.getById(courseId);
        if (course.getEnrolledStudents().contains(student)) {
            throw new DuplicateEntryException("Student already enrolled in course!");
        }
        if (course.getWaitlist().contains(student)) {
            throw new DuplicateEntryException("Student already waitlisted!");
        }
        if (course.getEnrolledStudents().size() <= course.getCapacity()) {
            course.getEnrolledStudents().add(student);
            return "Student successfully added to course";
        }
        course.getWaitlist().offer(student);
        return "Student added to course waitlist";
    }

    @Override
    public String dropStudentFromCourse(String studentId, String courseId) {
        Student student = studentService.getById(studentId);
        Course course = courseService.getById(courseId);
        if (!course.getEnrolledStudents().remove(student)) {
            throw new StudentNotFoundException("Student was not enrolled in this course");
        }
        Student nextStudent = course.getWaitlist().poll();
        if (nextStudent != null) {
            course.getEnrolledStudents().add(nextStudent);
            return "Dropped Student. Promoted waitlisted student: " + nextStudent.getName();
        }
        return "Dropped Student. No one on waitlist";
    }

    @Override
    public List<Student> listStudentsInCourse(String courseId) {
        Course course = courseService.getById(courseId);
        if (course == null) {
            throw new CourseNotFoundException("Course not found! Please enter a valid course id");
        }
        return new ArrayList<>(course.getEnrolledStudents());
    }

    @Override
    public List<Student> listWaitlistedStudents(String courseId) {
        Course course = courseService.getById(courseId);
        return new ArrayList<>(course.getWaitlist());
    }

    @Override
    public List<Student> listStudentsByBranchInAllCourses(String branch) {
        List<Course> courses = courseService.getAll();
        Set<Student> studentSet = new HashSet<>();
        for (Course course : courses) {
            studentSet.addAll(course.getEnrolledStudents().stream()
                    .filter(student -> student.getBranch().equalsIgnoreCase(branch)).toList());
        }
        return new ArrayList<>(studentSet);
    }

    @Override
    public int getEnrollmentCount(String courseId) {
        Course course = courseService.getById(courseId);
        return course.getEnrolledStudents().size();
    }

    @Override
    public int getWaitlistCount(String courseId) {
        Course course = courseService.getById(courseId);
        return course.getWaitlist().size();
    }

    @Override
    public String isStudentEnrolledOrWaitlisted(String studentId, String courseId) {
        Student student = studentService.getById(studentId);
        Course course = courseService.getById(courseId);
        if (course.getEnrolledStudents().contains(student)) {
            return "Student is enrolled in the course";
        } else if (course.getWaitlist().contains(student)) {
            return "Student is waitlisted in the course";
        }
        return "Student is neither enrolled nor waitlised in the course";
    }

}
