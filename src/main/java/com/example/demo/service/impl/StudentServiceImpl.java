package com.example.demo.service.impl;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
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
    public boolean save(Student s) {
        return studentRepo.save(s);
    }

    @Override
    public List<Student> update(Student s,int id){
        return studentRepo.update(s,id);
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
}
