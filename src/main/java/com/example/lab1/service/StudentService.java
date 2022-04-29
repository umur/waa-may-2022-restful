package com.example.lab1.service;

import com.example.lab1.domain.Course;
import com.example.lab1.domain.Student;
import com.example.lab1.dtos.StudentDTO;

import java.util.Collection;

public interface StudentService {
     Collection<StudentDTO> getStudents();

     StudentDTO getStudent(long id);

     StudentDTO createStudent(Student student);

     void modifyStudent(long id, Student student);

     void deleteStudent(long id);

     StudentDTO addCourse(long id, Course course);

     Collection<StudentDTO> getStudentsByMajor(String major);

     Collection<Course> getCoursesByStudentId(long id);
}
