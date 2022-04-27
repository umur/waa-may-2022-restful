package com.example.lab1.service.impl;

import com.example.lab1.domain.Course;
import com.example.lab1.domain.Student;
import com.example.lab1.dtos.StudentDTOV1;
import com.example.lab1.dtos.StudentDTOV2;
import com.example.lab1.repository.StudentRepository;
import com.example.lab1.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplV2 implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImplV2(StudentRepository studentRepository,
                                ModelMapper modelMapper){
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;

    }

    public Collection<StudentDTOV1> getStudents(){
        return studentRepository
                .getStudents()
                .stream()
                .map(student -> modelMapper.map(student, StudentDTOV2.class))
                .collect(Collectors.toList());
    }

    public StudentDTOV1 getStudent(long id){
        return modelMapper.map(studentRepository.getStudent(id),
                                StudentDTOV2.class);
    }

    public StudentDTOV1 createStudent(Student student) {

        return modelMapper.map(studentRepository.createStudent(student),
                                StudentDTOV2.class);
    }

    public void modifyStudent(long id, Student student) {
        studentRepository.modifyStudent(id, student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteStudent(id);
    }

    public StudentDTOV1 addCourse(long id, Course course) {
        Optional<Student> student = Optional.ofNullable(studentRepository.getStudent(id));
        student.ifPresent(value -> value.addCourse(course));
        return modelMapper.map(student.get(),StudentDTOV2.class);
    }

    public Collection<StudentDTOV1> getStudentsByMajor(String major) {
        return studentRepository
                        .getStudentsByMajor(major)
                        .stream()
                        .map(student -> modelMapper.map(student, StudentDTOV2.class))
                        .collect(Collectors.toList());
    }

    public Collection<Course> getCoursesByStudentId(long id) {
        Optional<Student> student = Optional.ofNullable(studentRepository.getStudent(id));
        return student.<Collection<Course>>map(Student::getCoursesTaken).orElse(null);
    }
}
