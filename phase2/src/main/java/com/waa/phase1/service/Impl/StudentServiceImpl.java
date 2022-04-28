package com.waa.phase1.service.Impl;

import com.waa.phase1.domain.Course;
import com.waa.phase1.domain.Student;
import com.waa.phase1.dto.CourseDto;
import com.waa.phase1.dto.StudentDto;
import com.waa.phase1.repository.CourseRepository;
import com.waa.phase1.repository.StudentRepository;
import com.waa.phase1.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Override
    public void save(StudentDto s) {
        studentRepository.save(s.toStudent());
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public List<StudentDto> getAll() {
        var students = studentRepository.getAll();
        return students.stream()
                .map(StudentDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getById(Long id) {
        var student = studentRepository.getById(id);
        if (student == null) return null;
        return new StudentDto(student);
    }

    @Override
    public void update(Long id, StudentDto s) {
        studentRepository.update(id, s.toStudent());
    }

    @Override
    public void addCourse(Long id, Long c) {
        if (c == null) return;

        var student = studentRepository.getById(id);

        var notPresent = student.getCoursesTaken().stream()
                .anyMatch(l -> c.equals(l));
        if (!notPresent) {
            studentRepository.addCourse(id, c);
        }
    }

    @Override
    public List<StudentDto> getByMajor(String major) {
        return studentRepository.getByMajor(major).stream()
                .map(StudentDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCourseByStudentId(Long id) {
        var courseIds = studentRepository.getCoursesByStudentId(id);
        return courseIds.stream()
                .map(courseRepository::getById)
                .filter(Objects::nonNull)
                .map(CourseDto::new)
                .collect(Collectors.toList());
    }


}
