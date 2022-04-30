package edu.miu.phase2.service;

import edu.miu.phase2.dto.CourseDto;
import edu.miu.phase2.dto.StudentDto;
import edu.miu.phase2.entity.Course;
import edu.miu.phase2.entity.Student;

import java.util.List;

public interface StudentService {
    void save(StudentDto student);

    void update(StudentDto student, int id);

    void delete(int id);

    List<StudentDto> getAll();

    StudentDto getById(int id);

    List<StudentDto> getStudentsByMajor(String major);

    List<CourseDto> getCoursesByStudentId(int studentId);




}
