package com.pprajapati.server.repository;

import com.pprajapati.server.domain.Course;
import com.pprajapati.server.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    private static List<Student> students = new ArrayList<>(){
        {
            add(new Student(1, "Puru", "Prajapati", "pprajapati@miu.edu", "CS", List.of(new Course[]{
                    new Course(1, "WAA", "CS5"),
                    new Course(2, "WAP", "CS4"),
                    new Course(3, "MPP", "CS3")
            })));
            add(new Student(2, "Test", "Test", "ttest@miu.edu", "MSD", List.of(new Course[]{
                    new Course(1, "WAA", "CS5"),
                    new Course(2, "WAP", "CS4"),
                    new Course(3, "MPP", "CS3"),
                    new Course(4, "FPP", "CS2")
            })));
        }
    };

    public static List<Student> getStudents() {
        return students;
    }

    public void save(Student s){
        if(students.stream()
                .noneMatch(st->st.getId() == s.getId())){
            students.add(s);
        }
    }

    public void delete(int id){
        students.stream()
                .filter(student -> student.getId() == id)
                .forEach(s->students.remove(s));
    }

    public void update(int id, Student s){
        students.stream()
                .filter(student -> student.getId() == id)
                .forEach((std->students.remove(std)));
        students.add(s);
    }

    public Student getById(int id) {
        return students.stream()
                .filter(s->s.getId() == id)
                .findFirst()
                .orElse(null);
    }


}
