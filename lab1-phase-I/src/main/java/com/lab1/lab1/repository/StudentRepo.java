package com.lab1.lab1.repository;

import com.lab1.lab1.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    private static List<Student> students;

    static {
        students =  new ArrayList<>();

    }
}
