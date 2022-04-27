package com.example.demo.repo;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    List<Student> students = new ArrayList<>();

    public void save(Student s){
        if(students.stream().noneMatch(obj->obj.getId()==s.getId())){
            students.add(s);
        }
    }
    public void update(int id, Student s){
        if(students.stream().anyMatch(obj->obj.getId()==id)){
            delete(id);
            save(s);
        }
    }
    public void delete(int id) {
        Student obj =students
                .stream()
                .filter(s -> s.getId() == id).findFirst().orElse(null);
        students.remove(obj);
    }

    public Student getById(int id) {
        return students
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);

    }

    public List<Student> getAll(){
        return students;

    }

    public List<Student> getStudentsByMajor  (String major){
        return students
                .stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudentId(int id){
        return getById(id).getCoursesTaken();
    }
}
