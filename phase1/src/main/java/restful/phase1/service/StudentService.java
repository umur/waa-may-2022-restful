package restful.phase1.service;

import restful.phase1.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void save(Student s);

    void delete(int id);

    Student getById(int id);

    Student getByFirstName(String fname);

    List<Student> getStudentsByMajor(String major);

    List<String> getCoursesByStudentId(int id);
}
