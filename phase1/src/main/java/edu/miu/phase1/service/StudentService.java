package edu.miu.phase1.service;

import edu.miu.phase1.entity.Course;
import edu.miu.phase1.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);

    void update(Student student, int id);

    void delete(int id);

    List<Student> getAll();

    Student getById(int id);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(int studentId);




}
