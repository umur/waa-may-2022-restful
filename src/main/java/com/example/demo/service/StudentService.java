package com.example.demo.service;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import com.example.demo.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public List<Student> getAll();

    public boolean save(StudentDto s);

    public List<Student> update(StudentDto s, int id);

    public void delete(int id);

    public List<Student> getAllV2(String major);

    public List<Course> getCourseTaken(int id);

    public Student studentFromDto(StudentDto stu);

    public Student getByID(int id);
}