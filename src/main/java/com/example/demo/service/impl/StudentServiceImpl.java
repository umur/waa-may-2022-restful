package com.example.demo.service.impl;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

//@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public boolean save(Student p) {
        return studentRepo.save(p);
    }
}
