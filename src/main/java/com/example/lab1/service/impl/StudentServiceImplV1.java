package com.example.lab1.service.impl;

import com.example.lab1.domain.Course;
import com.example.lab1.domain.Student;
import com.example.lab1.dtos.StudentDTO;
import com.example.lab1.repository.StudentRepository;
import com.example.lab1.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplV1 implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImplV1(StudentRepository studentRepository,
                                ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.studentRepository = studentRepository;
    }

    public Collection<StudentDTO> getStudents(){
        Optional<Collection<Student>> students = Optional.ofNullable(studentRepository.getStudents());
         return students
                .get()
                .stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    public StudentDTO getStudent(long id){
        return modelMapper.map(studentRepository.getStudent(id), StudentDTO.class);
    }

    public StudentDTO createStudent(Student student) {
        return modelMapper.map(studentRepository.createStudent(student), StudentDTO.class);
    }

    public void modifyStudent(long id, Student student) {
        studentRepository.modifyStudent(id, student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteStudent(id);
    }

    public StudentDTO addCourse(long id, Course course) {
        Optional<Student> student = Optional.ofNullable(studentRepository.getStudent(id));
        student.ifPresent(value -> value.addCourse(course));
        return modelMapper.map(student.get(), StudentDTO.class);
    }

    public Collection<StudentDTO> getStudentsByMajor(String major) {
        return studentRepository
                .getStudentsByMajor(major)
                .stream()
                .map(student -> modelMapper.map(student, StudentDTO.class))
                .collect(Collectors.toList());
    }

    public Collection<Course> getCoursesByStudentId(long id) {
        Optional<Student> student = Optional.ofNullable(studentRepository.getStudent(id));
        return student.<Collection<Course>>map(Student::getCoursesTaken).orElse(null);
    }
}
