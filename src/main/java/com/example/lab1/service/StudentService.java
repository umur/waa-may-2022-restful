package com.example.lab1.service;

import com.example.lab1.domain.Course;
import com.example.lab1.domain.Student;
import com.example.lab1.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Collection<Student> getStudents(){
        return studentRepository.getStudents();
    }

    public Student getStudent(long id){
        return studentRepository.getStudent(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.createStudent(student);
    }

    public void modifyStudent(long id, Student student) {
        studentRepository.modifyStudent(id, student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteStudent(id);
    }

    public Student addCourse(long id, Course course) {
        Optional<Student> student = Optional.ofNullable(studentRepository.getStudent(id));
        student.ifPresent(value -> value.addCourse(course));
        return student.get();
    }
}
