package com.example.lab2.repository;

import com.example.lab2.entity.Course;
import com.example.lab2.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

static List<Student> studentList = new ArrayList<>();
static List<Course> courseList = new ArrayList<>();
static{
    courseList.add(new Course(1,"waa","4578"));
    courseList.add(new Course(2,"Mpp","4578CC"));
    studentList.add(new Student(1,"Sandesh","Rauth","sandesh.rauth@gmail.com","mscs",courseList));
    studentList.add(new Student(2,"Mandesh","Mauth","mandesh.mauth@gmail.com","msd",courseList));
}

public List<Student> getAllStudent(){
    return studentList.stream().filter(item-> !item.deleted).collect(Collectors.toList());
}

public Student getStudentById(int id){
    return studentList.stream().filter(item->item.id == id && !item.deleted).findFirst().get();
}

public void deleteStudentById(int id){
studentList.stream().filter(item-> item.id == id).findFirst().get().setDeleted(true);
}

public List<Student> getStudentsByMajor(String major){
  return studentList.stream().filter(item-> item.major.equals(major)).collect(Collectors.toList());
}


}
