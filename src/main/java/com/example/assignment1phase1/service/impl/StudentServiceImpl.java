package com.example.assignment1phase1.service.impl;

import com.example.assignment1phase1.entity.Course;
import com.example.assignment1phase1.entity.Student;
import com.example.assignment1phase1.repository.StudentRepo;

import com.example.assignment1phase1.service.StudentService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;

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
    public void save(Student s) {
        studentRepo.save(s);

    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public Student update(Student s, int id) {
       return  studentRepo.update(s, id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        System.out.println("hiiii");
        return studentRepo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
