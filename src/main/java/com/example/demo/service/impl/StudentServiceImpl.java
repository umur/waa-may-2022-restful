package com.example.demo.service.impl;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import com.example.demo.dto.StudentDto;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
//    @Autowired
//    private StudentRepo studentRepo;
    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public boolean save(StudentDto s) {
        Student stu = studentFromDto(s);
        return studentRepo.save(stu);
    }

    @Override
    public List<Student> update(StudentDto s,int id){
        Student stu = studentFromDto(s);
        return studentRepo.update(stu,id);
    }

    @Override
    public void delete(int id){
         studentRepo.delete(id);
    }

    @Override
    public List<Student> getAllV2(String major){
        return studentRepo.getAllV2(major);
    }

    @Override
    public List<Course> getCourseTaken(int id){
        return studentRepo.getCourse(id);
    }

    @Override
    public Student studentFromDto(StudentDto stu){
        Student s = new Student();
        s.setId(stu.getId());
        s.setEmail(stu.getEmail());
        s.setCourseTaken(stu.getCourseTaken());
        s.setFirstName(stu.getFirstName());
        s.setLastName(stu.getLastName());
        s.setGpa(stu.getGpa());
        s.setMajor(stu.getMajor());
        return s;
    }
}
