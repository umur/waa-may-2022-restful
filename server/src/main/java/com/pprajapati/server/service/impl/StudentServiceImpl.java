package com.pprajapati.server.service.impl;

import com.pprajapati.server.domain.Student;
import com.pprajapati.server.repository.StudentRepo;
import com.pprajapati.server.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
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
    public List<Student> getAll() {
        return studentRepo.getStudents();
    }

    @Override
    public Student getById(int id) {
        return studentRepo.getById(id);
    }

    @Override
    public void update(int id, Student s) {
         studentRepo.update(id, s);
    }
}
