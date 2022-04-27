package com.lab1.lab1.service.impl;

import com.lab1.lab1.model.Course;
import com.lab1.lab1.model.Student;
import com.lab1.lab1.repository.StudentRepo;
import com.lab1.lab1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Autowired
    private static StudentRepo studentRepo;

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
        return studentRepo.getAll();
    }

    @Override
    public Student getById(int id) {
        return studentRepo.getById(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public  List<Course> getCoursesByStudentId(int id) {
        return studentRepo.getCoursesByStudentId(id);
    }
}
