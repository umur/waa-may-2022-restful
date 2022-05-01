package com.example.phase2.repository;

import com.example.phase2.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    private static ArrayList<Student> students = new ArrayList<>();

    public List<Student> getAll() {
        return students;
    }

    public void save(Student s) {
        students.add(s);
    }
}
