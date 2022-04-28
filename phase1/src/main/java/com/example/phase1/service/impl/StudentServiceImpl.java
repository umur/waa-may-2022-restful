package com.example.phase1.service.impl;

import com.example.phase1.domain.Student;
import com.example.phase1.domain.Student2;
import com.example.phase1.repository.StudentRepository;
import com.example.phase1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public List<Student2> getAll2() {
        return studentRepository.getAll2();
    }

    @Override
    public List<Student2> getStudentByMajor(String major) {
        return studentRepository.getStudentByMajor(major);
    }


    @Override
    public void save(Student s) {
        studentRepository.save(s);
    }

    @Override
    public void save2(Student2 s) {
        studentRepository.save2(s);
    }

    @Override
    public void update(Student s, int id) {
        studentRepository.update(s, id);
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(id);
    }

    @Override
    public Student getById(int id) {
        return null;
    }
}
