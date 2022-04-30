package edu.miu.phase1.service.impl;


import edu.miu.phase1.entity.Course;
import edu.miu.phase1.entity.Student;
import edu.miu.phase1.repository.StudentRepository;
import edu.miu.phase1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
// Not for me: With Lombok, it's possible to generate a constructor for either all class's fields (with @AllArgsConstructor)
// or all final class's fields (with @RequiredArgsConstructor).
// Moreover, if you still need an empty constructor, you can append an additional @NoArgsConstructor annotation.
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public void save(Student student) {
        studentRepository.save(student);

    }

    @Override
    public void update(Student student, int id) {
        studentRepository.update(student, id);
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(int id) {
       return studentRepository.findById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
       return studentRepository.findStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepository.findById(studentId).getCoursesTaken();
    }
}
