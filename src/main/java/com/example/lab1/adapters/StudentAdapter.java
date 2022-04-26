package com.example.lab1.adapters;

import com.example.lab1.domain.Student;
import com.example.lab1.dtos.StudentDTOV1;
import com.example.lab1.dtos.StudentDTOV2;

public class StudentAdapter {
    public static StudentDTOV1 getStudentV1(Student student){
        return new StudentDTOV1(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getMajor(),
                student.getCoursesTaken()
        );
    }
    public static StudentDTOV2 getStudentV2(Student student){
        return new StudentDTOV2(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getMajor(),
                student.getCoursesTaken(),
                student.getGpa()
        );
    }
}
