package HandsOn.service;

import java.util.List;

import HandsOn.model.Student;

public interface RegistrationService {
    String registerStudentToCourse(String studentId, String courseId);

    String dropStudentFromCourse(String studentId, String courseId);

    List<Student> getStudentsInCourse(String courseId);

    List<Student> getWaitlistedStudents(String courseId);

    List<Student> getStudentsByBranchInAllCourses(String branch);

    int getEnrollmentCount(String courseId);

    int getWaitlistCount(String courseId);

    String isStudentEnrolledOrWaitlisted(String studentId, String courseId);

}
