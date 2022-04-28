package restful.phase1.service.impl;

import org.springframework.stereotype.Service;
import restful.phase1.domain.Student;
import restful.phase1.repository.StudentRepo;
import restful.phase1.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    @Override
    public List<Student> getAllStudents() {
        return studentRepo.getAllStudents();
    }

    @Override
    public void save(Student s) {
        studentRepo.save(s);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public Student getById(int id) {
        return studentRepo.getById(id);
    }

    @Override
    public Student getByFirstName(String fname) {
        return studentRepo.getByFirstName(fname);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public List<String> getCoursesByStudentId(int id) {
        return studentRepo.getCoursesByStudentId(id);
    }
}
