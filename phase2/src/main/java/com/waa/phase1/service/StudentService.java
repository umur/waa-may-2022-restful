package com.waa.phase1.service;

import com.waa.phase1.domain.Course;
import com.waa.phase1.domain.Student;
import com.waa.phase1.dto.CourseDto;
import com.waa.phase1.dto.StudentDto;

import java.util.List;

public interface StudentService {
    void save(StudentDto s);

    void delete(Long id);

    List<StudentDto> getAll();

    StudentDto getById(Long id);

    void update(Long id, StudentDto s);

    void addCourse(Long id, Long courseId);

    List<StudentDto> getByMajor(String major);

    List<CourseDto> getCourseByStudentId(Long id);
}
