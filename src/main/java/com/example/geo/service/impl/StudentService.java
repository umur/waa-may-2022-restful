package com.example.geo.service.impl;

import com.example.geo.domain.Course;
import com.example.geo.domain.Student;
import com.example.geo.repository.impl.StudentRepo;
import com.example.geo.service.ServiceInit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService implements ServiceInit<Student> {
    private final StudentRepo studentRepo;

    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    public void save(Student c) {
        studentRepo.save(c);
    }

    public void delete(int id) {
        studentRepo.delete((id));
    }

    public void update(int id, Student c) {
         studentRepo.update(id, c);
    }

    public Student getById(int id) {
        return studentRepo.getById(id);
    }
    public List<Student> getStudentsByMajor(String major) {
        return  studentRepo.getStudentsByMajor(major);
    }
    public List<Course> getCoursesByStudentId(int studentId){
        return studentRepo.getCoursesByStudentId(studentId);
    }
}

