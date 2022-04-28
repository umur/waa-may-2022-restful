package com.example.lab1.repo;

import com.example.lab1.entity.Course;
import com.example.lab1.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepo {
    private static List<Student> studentList = new ArrayList<>(){{
        add(new Student(1, "John", "Doe", "john@miu.edu", "Computer Science", new ArrayList<>(){{ add(new Course(1, "WAA", "CS1")); add(new Course(2, "WAP", "CS32"));}}));
    }};

    public List<Student> getAll() {
        return studentList;
    }

    public void save(Student student) {
        studentList.add(student);
    }

    public Optional<Student> getById(int id) {
        return studentList.stream().filter(s -> s.getId() == id).findFirst();
    }

    public void delete(int id){
        var student = studentList.stream().filter(s -> s.getId() == id).findAny();
        if (student.isPresent()) studentList.remove(student.get());
    }

    public void update(int id, Student studentUpdate){
        studentList.stream().filter(s -> s.getId() == id).findFirst().map(s -> {
            int index = studentList.indexOf(s);
            return index >= 0 ? studentList.set(index, new Student(id, studentUpdate.getFirstname(), studentUpdate.getLastname(), studentUpdate.getEmail(), studentUpdate.getEmail(), studentUpdate.getCoursesTaken())) : null;
        });

    }

    public List<Student> getStudentsByMajor(String filter){
        return studentList.stream().filter(s -> s.getMajor().equalsIgnoreCase(filter)).toList();
    }

    public List<Course> getCoursesByStudentId(int studentId){
        var student = studentList.stream().filter(s -> s.getId() == studentId).findFirst();
        if (student.isPresent()){
            return student.get().getCoursesTaken();
        }
        return null;
    }
}
