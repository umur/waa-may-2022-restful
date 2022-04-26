package com.waa.phase1.service.Impl;

import com.waa.phase1.domain.Course;
import com.waa.phase1.domain.Student;
import com.waa.phase1.repository.StudentRepository;
import com.waa.phase1.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public void save(Student s) {
        studentRepository.save(s);
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public void update(Long id, Student s) {
        studentRepository.update(id, s);
    }

    @Override
    public void addCourse(Long id, Course c) {
        studentRepository.addCourse(id, c);
    }

    @Override
    public List<Student> getByMajor(String major) {
        return studentRepository.getByMajor(major);
    }

    @Override
    public List<Course> getCourseByStudentId(Long id) {
        return studentRepository.getCoursesByStudentId(id);
    }


}
