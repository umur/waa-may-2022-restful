package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService{

    private final StudentRepo sRepo;

    @Override
    public void save(Student s) {
        sRepo.save(s);
    }

    @Override
    public void delete(int id) {
        sRepo.delete(id);
    }

    @Override
    public List<Student> getAll() {
        return sRepo.getAll();
    }

    @Override
    public Student getById(int id) {
        return sRepo.getById(id);
    }

    @Override
    public void update(int id, Student s) {
        sRepo.update(id,s);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return sRepo.getStudentsByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return sRepo.getCoursesByStudentId(id);
    }
}
