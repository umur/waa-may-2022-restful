package com.lab.restapi.service.impl;

import com.lab.restapi.dto.CourseDto;
import com.lab.restapi.dto.StudentDto;
import com.lab.restapi.entity.Course;
import com.lab.restapi.entity.Student;
import com.lab.restapi.repository.StudentRepository;
import com.lab.restapi.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(StudentDto student) {
        Student s = new Student();
        s.setId(student.getId());
        s.setFirstName(student.getFirstName());
        s.setLastName(student.getLastName());
        s.setMajor(student.getMajor());

        studentRepository.save(s);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<StudentDto> getAll() {
        //var entityList = courseRepository.getAll();
        var entityList = studentRepository.findAll();

        var result = new ArrayList<StudentDto>();

        entityList.forEach(s -> {
            StudentDto studentDto = new StudentDto();
            studentDto.setId(s.getId());
            studentDto.setFirstName(s.getFirstName());
            studentDto.setLastName(s.getLastName());
            studentDto.setMajor(s.getMajor());

            result.add(studentDto);
        });
        return result;
    }

    @Override
    public Student getById(long id) {
        return studentRepository.findById(id).get();
        //return studentRepository.getById(id);
    }

    @Override
    public void delete(long id) {
        studentRepository.deleteById(id);
        //studentRepository.delete(id);
    }

    @Override
    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.findAllByMajor(major);
    }

    @Override
    public List<Course> getCoursesByStudentId(long id) {
        Student stu = studentRepository.findById(id).get();

        var courses = stu.getCoursesTaken();

        return courses;
    }


}
