package com.example.phase2.service;
import com.example.phase2.dto.CourseDto;
import com.example.phase2.dto.StudentDto;
import com.example.phase2.dto.StudentGpaDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAll();

    List<StudentGpaDto> getAll2();

    List<CourseDto> getCoursesByStudentId(int id);

    List<StudentGpaDto> getStudentByMajor(String major);

    void save(StudentDto s);

    void save2(StudentGpaDto s);
    void update(StudentDto s, int id);

    void delete(int id);

    StudentDto getById(int id);

}
