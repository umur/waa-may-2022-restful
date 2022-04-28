package com.example.phase1.repository;

import com.example.phase1.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private static ArrayList<Student> students = new ArrayList<>();

    public List<Student> getAll() {
        return students;
    };

    public void save(Student s) {
        var nonExists =
                students.stream().noneMatch(l->l.getId() == s.getId());

        if (nonExists) {
            students.add(s);
        }
    }

    public void update(Student s) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == s.getId()) {
                students.set(i, s);
            }
        }
    }

    public void delete(int id) {
        students.stream().filter(l->l.getId() == id)
                .forEach(l-> students.remove(l));
    }
}
