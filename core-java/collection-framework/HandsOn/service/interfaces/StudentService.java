package HandsOn.service.interfaces;

import java.util.List;
import java.util.Map;

import HandsOn.model.Student;

public interface StudentService {
    void save(Student course);

    Student getById(String id);

    List<Student> getAll();

    void update(Student student);

    void delete(String id);

    Map<String, List<Student>> groupStudentsByBranch();
}
