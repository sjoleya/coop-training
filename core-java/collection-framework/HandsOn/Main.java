package HandsOn;

import java.util.List;
import java.util.Scanner;

import HandsOn.model.Course;
import HandsOn.model.Student;
import HandsOn.service.CourseService;
import HandsOn.service.RegistrationService;
import HandsOn.service.StudentService;
import HandsOn.service.impl.CourseServiceImpl;
import HandsOn.service.impl.RegistrationServiceImpl;
import HandsOn.service.impl.StudentServiceImpl;

public class Main {
    private static final StudentService studentService = new StudentServiceImpl();
    private static final CourseService courseService = new CourseServiceImpl();
    private static final RegistrationService registrationService = new RegistrationServiceImpl(studentService,
            courseService);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        do {
            try {
                System.out.println("\n--- University Course Registration System ---");
                System.out.println("1. Register Student to Course");
                System.out.println("2. Drop Student from Course");
                System.out.println("3. List Students in a Course");
                System.out.println("4. List Students by Branch In all courses");
                System.out.println("5. List Courses (sorted)");
                System.out.println("6. List Courses (filtered)");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> registerStudentToCourse();
                    case 2 -> dropStudentFromCourse();
                    case 3 -> listStudentsInCourse();
                    case 4 -> listStudentsByBranch();
                    case 5 -> listCoursesSorted();
                    case 6 -> listCoursesFiltered();
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("An error occured: " + e.getMessage() + "\nPlease try again!");
            }
        } while (choice != 0);
        System.out.println("Thank you for using the University Course Registration System!");
    }

    private static void registerStudentToCourse() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();

        String status = registrationService.registerStudentToCourse(studentId, courseId);
        System.out.println(status);
    }

    private static void dropStudentFromCourse() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();

        String status = registrationService.dropStudentFromCourse(studentId, courseId);
        System.out.println(status);
    }

    private static void listStudentsInCourse() {
        System.out.print("Enter Course ID: ");
        String courseId = scanner.nextLine();

        List<Student> students = registrationService.getStudentsInCourse(courseId);
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            System.out.println("Enrolled students:");
            students.forEach(student -> System.out.println("- " + student.getName() + " (" + student.getId() + ")"));
        }
    }

    private static void listStudentsByBranch() {
        System.out.print("Enter Branch Name: ");
        String branch = scanner.nextLine();

        List<Student> students = registrationService.getStudentsByBranchInAllCourses(branch);
        if (students.isEmpty()) {
            System.out.println("No students from branch '" + branch + "' are enrolled in any course.");
        } else {
            System.out.println("Students from " + branch + ":");
            students.forEach(student -> System.out.println("- " + student.getName() + " (" + student.getId() + ")"));
        }
    }

    private static void listCoursesSorted() {
        List<Course> courses = courseService.getCoursesSortedByEnrollments();
        System.out.println("Courses sorted by number of enrolled students:");
        for (Course course : courses) {
            System.out.println(course.getName() + " (" + course.getId() + ")" + " - Enrolled: "
                    + course.getEnrolledStudents().size());
        }
    }

    private static void listCoursesFiltered() {
        System.out.println("1. Filter by Instructor");
        System.out.println("2. Filter by Credits");
        System.out.print("Enter filter choice: ");
        int filterChoice = scanner.nextInt();
        scanner.nextLine();

        if (filterChoice == 1) {
            System.out.print("Enter instructor name: ");
            String instructor = scanner.nextLine();
            List<Course> courses = courseService.getCoursesFilteredByInstructor(instructor);
            courses.forEach(course -> System.out.println(course.getName() + " (" + course.getId() + ")"));
        } else if (filterChoice == 2) {
            System.out.print("Enter credit value: ");
            int credits = scanner.nextInt();
            List<Course> courses = courseService.getCoursesFilteredByCredits(credits);
            courses.forEach(course -> System.out.println(course.getName() + " (" + course.getId() + ")"));
        } else {
            System.out.println("Invalid filter option.");
        }
    }
}
