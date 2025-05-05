package HandsOn.service.interfaces;

import java.util.List;

import HandsOn.model.Student;

public interface RegistrationService {
    String registerStudentToCourse(String studentId, String courseId);

    String dropStudentFromCourse(String studentId, String courseId);

    List<Student> listStudentsInCourse(String courseId);

    List<Student> listWaitlistedStudents(String courseId);

    List<Student> listStudentsByBranchInAllCourses(String branch);

    int getEnrollmentCount(String courseId);

    int getWaitlistCount(String courseId);

    String isStudentEnrolledOrWaitlisted(String studentId, String courseId);

}
