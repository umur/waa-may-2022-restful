package com.vkarki.labone.service;

import com.vkarki.labone.domain.Student;
import com.vkarki.labone.dto.SimpleStudentDto;
import com.vkarki.labone.dto.SimpleStudentDtoV2;

import java.util.List;

public interface StudentService {
    void save(SimpleStudentDto student);

    void update(SimpleStudentDto student, int id);

    void delete(int id);

    List<SimpleStudentDto> getAll();

    List<SimpleStudentDtoV2> getAllV2();

    SimpleStudentDto getById(int id);

    List<SimpleStudentDtoV2> getStudentsByMajor(String major);

}
