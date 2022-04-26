package com.example.demo.repository;

import com.example.demo.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static ArrayList<Student> students = new ArrayList<>();

    public List<Student> getAll() {
        return students;
    }

    public boolean save(Student s) {
        List<Student> list = students.stream().filter(item->item.getId()==s.getId()).collect(Collectors.toList());
        if(list.isEmpty()){
            students.add(s);
            return true;
        }
        return false;
    }

    public void update(Student s,int id) {
        students.stream().filter(item->item.getId()==id).map(item->{
            return s;
        }).collect(Collectors.toList());
    }
}
