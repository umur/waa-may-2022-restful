package com.example.phase1.repository;

import com.example.phase1.domain.Course;
import com.example.phase1.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static ArrayList<Student> students = new ArrayList<>();

    public List<Student> getAll() {
        return students;
    }

    public List<Student> getStudentsByMajor(String major) {

        return students
                .stream()
                .filter(s->s.getMajor()==major)
                .collect(Collectors.toList());
    }

    public  List<Course> getStudentCourses(int id){
        return students.stream()
                .filter((s->s.getId()==id))
                .findFirst()
                .get().getCoursesTaken();

    }

    public void save(Student s) {
        students.add(s);
    }
}
