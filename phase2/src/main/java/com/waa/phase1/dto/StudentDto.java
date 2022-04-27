package com.waa.phase1.dto;

import com.waa.phase1.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;

    private List<Long> coursesTaken = new ArrayList<>();

    private int gpa;

    public StudentDto(Student s) {
        this.setId(s.getId());
        this.setFirstName(s.getFirstName());
        this.setLastName(s.getLastName());
        this.setEmail(s.getEmail());
        this.setMajor(s.getMajor());
        this.setCoursesTaken(s.getCoursesTaken());
    }

    public Student toStudent() {
        Student s = new Student();
        s.setId(getId());
        s.setFirstName(getFirstName());
        s.setLastName(getLastName());
        s.setEmail(getEmail());
        s.setMajor(getMajor());
        s.setCoursesTaken(getCoursesTaken());
        return s;
    }
}
