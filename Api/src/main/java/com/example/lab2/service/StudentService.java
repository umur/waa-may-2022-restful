package com.example.lab2.service;
import com.example.lab2.dto.StudentDto;
import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import java.util.List;
import java.util.stream.Collectors;

public interface StudentService {
     List<StudentDto> getAllStudent();

     StudentDto getStudentById(int id);

     void deleteStudentById(int id);

     List<StudentDto> getStudentsByMajor(String major);

     List<Course> getCoursesByStudentId(int id);
}
