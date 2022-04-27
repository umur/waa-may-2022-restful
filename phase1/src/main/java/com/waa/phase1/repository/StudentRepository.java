package com.waa.phase1.repository;

import com.waa.phase1.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private static final List<Student> students = new ArrayList<>();

    public List<Student> getAll() {
        return students;
    }

    public void save(Student s) {
        var notExists = students.stream()
                .filter(l -> Objects.equals(l.getId(), s.getId()))
                .noneMatch(l -> Objects.equals(l.getId(), s.getId()));
        if (notExists) {
            students.add(s);
        }
    }

    public void delete(Long id) {
        students.stream()
                .filter(student -> Objects.equals(student.getId(), id))
                .forEach(students::remove);
    }

    public Student getById(Long id) {
        return students.stream()
                .filter(l -> Objects.equals(l.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public void update(Long id, Student s) {
        Student student = getById(id);
        if (student != null) {
            student.setEmail(s.getEmail());
            student.setFirstName(s.getFirstName());
            student.setLastName(s.getLastName());
            student.setMajor(s.getMajor());
            student.setCoursesTaken(s.getCoursesTaken());
        }
    }

    public List<Student> getByMajor(String major) {
        return students.stream()
                .filter(l -> l.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public List<Long> getCoursesByStudentId(Long studentId) {
        return students.stream()
                .filter(l -> Objects.equals(l.getId(), studentId))
                .findFirst()
                .map(Student::getCoursesTaken)
                .orElse(Collections.emptyList());
    }

    public void addCourse(Long id, Long courseId) {
        students.stream()
                .filter(s -> Objects.equals(s.getId(), id))
                .findFirst().ifPresent(student -> {
                    student.getCoursesTaken().add(courseId);
                });
    }
}
