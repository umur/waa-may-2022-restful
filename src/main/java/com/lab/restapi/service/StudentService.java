package com.lab.restapi.service;

import com.lab.restapi.dto.StudentDto;
import com.lab.restapi.entity.Course;
import com.lab.restapi.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    void save(StudentDto student);

    void save(Student student);

    List<StudentDto> getAll();

    Student getById(long id);

    void delete(long id);

    List<Student> getStudentsByMajor(String major);

    List<Course> getCoursesByStudentId(long id);

}
