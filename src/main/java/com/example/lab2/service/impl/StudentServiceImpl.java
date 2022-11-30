package com.example.lab2.service.impl;

import com.example.lab2.entity.Student;
import com.example.lab2.repository.StudentRepo;
import com.example.lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    public final StudentRepo studentRepo;
    @Override
    public List<Student> getAllStudent() {
        return studentRepo.getAllStudent();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepo.getStudentById(id);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepo.deleteStudentById(id);
    }
}
