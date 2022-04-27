package com.example.lab1.service;

import com.example.lab1.domain.Course;
import com.example.lab1.domain.Student;
import com.example.lab1.dtos.StudentDTOV1;

import java.util.Collection;
import java.util.Optional;

public interface StudentService {
     Collection<StudentDTOV1> getStudents();

     StudentDTOV1 getStudent(long id);

     StudentDTOV1 createStudent(Student student);

     void modifyStudent(long id, Student student);

     void deleteStudent(long id);

     StudentDTOV1 addCourse(long id, Course course);

     Collection<StudentDTOV1> getStudentsByMajor(String major);

     Collection<Course> getCoursesByStudentId(long id);
}
