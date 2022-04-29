package restful.phase1.service;

import restful.phase1.domain.Student;
import restful.phase1.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAllStudents();

    void save(StudentDTO s);

    void delete(int id);

    StudentDTO getById(int id);

    StudentDTO getByFirstName(String fname);

    List<StudentDTO> getStudentsByMajor(String major);

    List<String> getCoursesByStudentId(int id);
}
