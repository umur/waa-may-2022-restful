package com.example.phase2.service;


import com.example.phase2.domain.Student;
import com.example.phase2.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAll();

    void save(StudentDto s);
}
