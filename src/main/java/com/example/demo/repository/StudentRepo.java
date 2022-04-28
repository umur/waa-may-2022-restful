package com.example.demo.repository;

import com.example.demo.domain.Course;
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

    public List<Student> update(Student s,int id) {
        students = new ArrayList<Student>(students.stream().map(item->{
            if(item.getId()==id){
                return s;
            }
            return item;
        }).collect(Collectors.toList()));
        List<Student> updated = students.stream().filter(item->item.getId()==id).collect(Collectors.toList());
        return updated;
    }

    public void delete(int id){
        students =  new ArrayList<Student>(students.stream().filter(item->item.getId()!=id).collect(Collectors.toList()));
    }
    public List<Student> getAllV2(String major){
        if(major!="") {
            return students
                .stream()
                .filter(item->item.getMajor().toLowerCase().contains(major.toLowerCase()))
                .collect(Collectors.toList());
        }
        return students;
    }
    public List<Course> getCourse(int id){
        List<Student> result = students
                .stream()
                .filter(item->item.getId()==id)
                .collect(Collectors.toList());

        return result.get(0).getCourseTaken();
    }
    public Student getByID(int id){
        List<Student> result = students.stream().filter(item->item.getId()==id).collect(Collectors.toList());
        return result.get(0);
    }
}
