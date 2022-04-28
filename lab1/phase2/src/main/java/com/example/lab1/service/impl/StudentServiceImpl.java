package com.example.lab1.service.impl;

import com.example.lab1.dto.CourseDTO;
import com.example.lab1.dto.StudentDTO;
import com.example.lab1.entity.Student;
import com.example.lab1.repo.StudentRepo;
import com.example.lab1.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public void save(StudentDTO s) {
        studentRepo.save(new Student(s.getId(), s.getFirstname(), s.getLastname(), s.getEmail(), s.getMajor(), s.getCoursesTaken()));
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public void update(int id, StudentDTO s) {
        studentRepo.update(id, new Student(s.getId(), s.getFirstname(), s.getLastname(), s.getEmail(), s.getMajor(), s.getCoursesTaken()));
    }

    @Override
    public List<StudentDTO> getAll() {
        return studentRepo.getAll().stream().map(s -> new StudentDTO(s.getId(), s.getFirstname(), s.getLastname(), s.getEmail(), s.getMajor(), s.getCoursesTaken(), s.getGpa())).toList();
    }

    @Override
    public StudentDTO getById(int id) {
        var s = studentRepo.getById(id);
        return new StudentDTO(s.getId(), s.getFirstname(), s.getLastname(), s.getEmail(), s.getMajor(), s.getCoursesTaken(), s.getGpa());

    }

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major).stream().map(s -> new StudentDTO(s.getId(), s.getFirstname(), s.getLastname(), s.getEmail(), s.getMajor(), s.getCoursesTaken(), s.getGpa())).toList();
    }

    @Override
    public List<CourseDTO> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId).stream().map(c -> new CourseDTO(c.getId(), c.getName(), c.getCode())).toList();
    }
}
