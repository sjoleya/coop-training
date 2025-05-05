package HandsOn.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import HandsOn.exceptions.StudentNotFoundException;
import HandsOn.model.Student;
import HandsOn.repo.StudentRepository;
import HandsOn.service.interfaces.StudentService;

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository = new StudentRepository();

    @Override
    public void save(Student student) {
        // TODO: Add Validations
        studentRepository.save(student);
    }

    @Override
    public Student getById(String id) {
        return studentRepository.getById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found!"));

    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }

    @Override
    public void delete(String id) {
        studentRepository.delete(id);
    }

    @Override
    public Map<String, List<Student>> groupStudentsByBranch() {
        List<Student> students = getAll();
        return students.stream().collect(Collectors.groupingBy(Student::getBranch));
    }

}
