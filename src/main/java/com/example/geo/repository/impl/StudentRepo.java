package com.example.geo.repository.impl;

import com.example.geo.domain.Course;
import com.example.geo.domain.Student;
import com.example.geo.repository.RepoInit;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo implements RepoInit<Student> {
    private static final ArrayList<Student> students=new ArrayList<>();

    static  {

        for (int i = 0; i < 101; i++) {
            List<Course> c = new ArrayList<>();
            for (int ii = 0; ii < 3; ii++) {
                c.add((new Course(ii, "name" + ii, "code" + ii)));
            }
            Student s = new Student(i, "firstName" + i, "lastName" + i, "email" + i + "@email.com", "major" + i, c,i*.2);
            students.add(s);
        }
    }
    public List<Student> getAll(){return students;}
    public void save(Student c){students.add(c);}
    public void delete(int id){students.removeIf(c->c.getId()==id);}
    public void update(int id,Student c) {
        int index = students.indexOf(getById(id));
        c.setId(id);
         students.set(index, c);
    }
    public Student getById(int id) {
        return students.stream().filter(cc -> cc.getId() == id).findFirst().orElse(null);
    }
    public List<Student> getStudentsByMajor(String major) {
        return students.stream().filter(cc -> cc.getMajor().equals(major)).collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int studentId) {
        Student s= students.stream().filter(cc -> cc.getId() == studentId).findFirst().orElse(null);
        if(s!=null)
        {
            return s.getCoursesTaken();
        }
        return null;


    }
}
