package com.miu.repository;

import com.miu.domain.Course;
import com.miu.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private static List<Student> students = new ArrayList<>();

    static {
        Student student = new Student(1L,"shree","krishna","s@gmail.com","compro");
        student.addCourse(new Course(1L,"WAA","CS-543"));
        student.addCourse(new Course(2L,"MWA","CS-546"));
        students.add(student);
    }

    public List<Student> findAll(){
        return students;
    }

    public Student save(Student student){
        this.students.add(student);
        return student;
    }

    public Student update(Student student, Long id){
        var mayBeStudent = students.stream().filter(stu -> stu.getId().equals(id)).findFirst();
        if(mayBeStudent.isPresent()){
            students.remove(mayBeStudent.get());
            students.add(student);
        }
        return student;
    }

    public void delete(Long id){
        var mayBeStudent = students.stream().filter(stu -> stu.getId().equals(id)).findFirst();
        if(mayBeStudent.isPresent()){
            students.remove(mayBeStudent.get());
            var student = mayBeStudent.get();
            student.setDeleted(true);
            students.add(student);
        }
    }

    public Student findById(Long id){
        return students.stream().filter(stu -> stu.getId().equals(id)).findFirst().get();
    }

}
