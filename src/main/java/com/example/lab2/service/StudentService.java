package com.example.lab2.service;
import com.example.lab2.entity.Student;
import java.util.List;
import java.util.stream.Collectors;

public interface StudentService {
     List<Student> getAllStudent();

     Student getStudentById(int id);

     void deleteStudentById(int id);

     List<Student> getStudentsByMajor(String major);
}
