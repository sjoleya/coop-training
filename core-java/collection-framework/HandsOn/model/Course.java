package HandsOn.model;

import java.util.*;

public class Course {
    private String id;
    private String name;
    private String description;
    private String instructorName;
    private int capacity;
    private int credits;
    private Set<Student> enrolledStudents = new TreeSet<>();
    private Queue<Student> waitlist = new LinkedList<>();

    public Course(String id, String name, String description, String instructorName, int capacity, int credits) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.instructorName = instructorName;
        this.capacity = capacity;
        this.credits = credits;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCredits() {
        return credits;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Queue<Student> getWaitlist() {
        return waitlist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Course course))
            return false;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // @Override
    // public String toString() {
    // return name + " (" + id + ")";
    // }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + id + '\'' +
                ", courseName='" + name + '\'' +
                ", description='" + description + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", capacity=" + capacity +
                ", credits=" + credits +
                ", enrolled=" + enrolledStudents.size() +
                ", waitlistSize=" + waitlist.size() +
                '}';
    }
}
