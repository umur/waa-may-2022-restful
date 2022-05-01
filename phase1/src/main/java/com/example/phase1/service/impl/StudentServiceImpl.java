package com.example.phase1.service.impl;

import com.example.phase1.domain.Course;
import com.example.phase1.domain.Student;
import com.example.phase1.repository.StudentRepo;
import com.example.phase1.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    private StudentServiceImpl(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }
    @Override
    public List<Student> getAll() {
        return studentRepo.getAll();
    }

    @Override
    public void save(Student s) {

        s.setGpa(0.0);
        studentRepo.save(s);
    }

    @Override
    public void saveV2(Student s) {


        studentRepo.save(s);
    }

    @Override
    public  List<Student> getByMajor(String major){
        return
                studentRepo.getStudentsByMajor(major);
    }

    @Override
    public  List<Course> getStudentCourses(int id){
        return studentRepo.getStudentCourses(id);
    }


}
