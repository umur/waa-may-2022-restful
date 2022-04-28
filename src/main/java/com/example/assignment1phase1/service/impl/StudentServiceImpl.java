package com.example.assignment1phase1.service.impl;

import com.example.assignment1phase1.dto.StudentDto;
import com.example.assignment1phase1.entity.Course;
import com.example.assignment1phase1.entity.Student;
import com.example.assignment1phase1.repository.StudentRepo;

import com.example.assignment1phase1.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;

    }

    @Override
    public List<StudentDto> getAll() {
        List<StudentDto> studentDtos = new ArrayList<>();
        List<Student> students = studentRepo.getAll();
        StudentDto studentDto = new StudentDto();
        for (int i = 0; i < students.size(); i++) {

            studentDto.setId(students.get(i).getId());
            studentDto.setFirstName(students.get(i).getFirstName());
            studentDto.setLastName(students.get(i).getLastName());
            studentDto.setCoursesTaken(students.get(i).getCoursesTaken());
            studentDto.setMajor(students.get(i).getMajor());
            studentDtos.add(studentDto);

        }
        return studentDtos;
    }

    @Override
    public StudentDto getById(int id) {
        StudentDto studentDto = new StudentDto();
        Student s= studentRepo.getById(id);
        studentDto.setId(s.getId());
        studentDto.setFirstName(s.getFirstName());
        studentDto.setLastName(s.getLastName());
        studentDto.setCoursesTaken(s.getCoursesTaken());
        studentDto.setMajor(s.getMajor());
        return studentDto;
    }


    @Override
    public void save(StudentDto studentDto) {
        Student s=new Student();
        s.setId(studentDto.getId());
        s.setFirstName(studentDto.getFirstName());
        s.setLastName(studentDto.getLastName());
        s.setCoursesTaken(studentDto.getCoursesTaken());
        s.setMajor(studentDto.getMajor());
        s.setCreatedDate(LocalDateTime.now());
        studentRepo.save(s);

    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public StudentDto update(StudentDto studentDto, int id) {
        Student s=new Student();
        s.setId(studentDto.getId());
        s.setFirstName(studentDto.getFirstName());
        s.setLastName(studentDto.getLastName());
        s.setCoursesTaken(studentDto.getCoursesTaken());
        s.setMajor(studentDto.getMajor());


         studentRepo.update(s, id);
         return  studentDto;

    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        List<StudentDto> studentDtos = new ArrayList<>();
        List<Student> students =  studentRepo.getStudentsByMajor(major);
        StudentDto studentDto = new StudentDto();
        for (int i = 0; i < students.size(); i++) {

            studentDto.setId(students.get(i).getId());
            studentDto.setFirstName(students.get(i).getFirstName());
            studentDto.setLastName(students.get(i).getLastName());
            studentDto.setCoursesTaken(students.get(i).getCoursesTaken());
            studentDto.setMajor(students.get(i).getMajor());
            studentDtos.add(studentDto);

        }
        return studentDtos;

    }

    @Override
    public List<Course> getCoursesByStudentId(int studentId) {
        return studentRepo.getCoursesByStudentId(studentId);
    }
}
