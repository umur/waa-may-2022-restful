package com.example.lab2.service.impl;
import com.example.lab2.dto.StudentDto;
import com.example.lab2.entity.Course;
import com.example.lab2.repository.StudentRepo;
import com.example.lab2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<StudentDto> getAllStudent() {
        var entity = studentRepo.getAllStudent();
        return entity.stream().map(item-> modelMapper.map(item,StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(int id) {
        var entity = studentRepo.getStudentById(id);
        return modelMapper.map(entity,StudentDto.class);
    }

    @Override
    public void deleteStudentById(int id) {
        studentRepo.deleteStudentById(id);
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        var students = studentRepo.getStudentsByMajor(major);
        return modelMapper.map(students,new TypeToken<List<StudentDto>>(){}.getType());
    }

    @Override
    public List<Course> getCoursesByStudentId(int id) {
        return studentRepo.getCoursesByStudentId(id);
    }
}
