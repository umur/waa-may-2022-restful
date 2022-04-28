package com.example.phase2.repo;

import com.example.phase2.dto.CourseDto;
import com.example.phase2.dto.StudentDto;
import com.example.phase2.dto.StudentGpaDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    private static ArrayList<StudentDto> students = new ArrayList<>();
    private static ArrayList<StudentGpaDto> students2 = new ArrayList<>();

    public List<StudentDto> getAll() {
        return students;
    };

    public List<StudentGpaDto> getAll2() {
        return students2;
    }

    public List<CourseDto> getCoursesByStudentId(int id) {
        var result = students2.stream()
                .filter(l->l.getId() == id)
                .findFirst();

        return result.map(StudentGpaDto::getCoursesTaken).orElse(null);
    }

    public List<StudentGpaDto> getStudentByMajor(String major) {
        return students2.stream().filter(l-> l.getMajor().equals(major))
                .collect(Collectors.toList());
    }

    public void save(StudentDto s) {
        var nonExists =
                students.stream().noneMatch(l->l.getId() == s.getId());

        if (nonExists) {
            students.add(s);
        }
    }

    public void save2(StudentGpaDto s) {
        var nonExists =
                students2.stream().noneMatch(l->l.getId() == s.getId());

        if (nonExists) {
            students2.add(s);
        }
    }

    public void update(StudentDto s, int id) {
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
