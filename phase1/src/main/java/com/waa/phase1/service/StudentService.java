package com.waa.phase1.service;

import com.waa.phase1.domain.Course;
import com.waa.phase1.domain.Student;

import java.util.List;

public interface StudentService {
    void save(Student s);

    void delete(Long id);

    List<Student> getAll();

    Student getById(Long id);

    void update(Long id, Student s);

    void addCourse(Long id, Long courseId);

    List<Student> getByMajor(String major);

    List<Course> getCourseByStudentId(Long id);
}
