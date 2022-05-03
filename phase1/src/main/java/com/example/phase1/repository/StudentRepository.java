package com.example.phase1.repository;

import com.example.phase1.domain.Course;
import com.example.phase1.domain.Student;
import com.example.phase1.domain.Student2;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Student2> students2 = new ArrayList<>();

    public List<Student> getAll() {
        return students;
    };

    public List<Student2> getAll2() {
        return students2;
    }

    public List<Course> getCoursesByStudentId(int id) {
        var result = students2.stream()
                .filter(l->l.getId() == id)
                .findFirst();

        return result.get().getCoursesTaken();
    }

    public List<Student2> getStudentByMajor(String major) {
        return students2.stream().filter(l-> l.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public void save(Student s) {
        var nonExists =
                students.stream().noneMatch(l->l.getId() == s.getId());

        if (nonExists) {
            students.add(s);
        }
    }

    public void save2(Student2 s) {
        var nonExists =
                students2.stream().noneMatch(l->l.getId() == s.getId());

        if (nonExists) {
            students2.add(s);
        }
    }

    public void update(Student s, int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.get(i).setFirstName(s.getFirstName());
                students.get(i).setLastName(s.getLastName());
                students.get(i).setCoursesTaken(s.getCoursesTaken());
                students.get(i).setEmail(s.getEmail());
                students.get(i).setMajor(s.getMajor());
            }
        }
    }

    public void delete(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
            }
        }
     }
}
