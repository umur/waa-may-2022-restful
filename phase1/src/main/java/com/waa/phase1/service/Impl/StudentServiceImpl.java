package com.waa.phase1.service.Impl;

import com.waa.phase1.domain.Course;
import com.waa.phase1.domain.Student;
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
    public void save(Student s) {
        studentRepository.save(s);
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public void update(Long id, Student s) {
        studentRepository.update(id, s);
    }

    @Override
    public void addCourse(Long id, Long c) {
        var student = studentRepository.getById(id);

        var notPresent = student.getCoursesTaken().stream()
                .anyMatch(l -> l.equals(c));
        if (!notPresent) {
            studentRepository.addCourse(id, c);
        }
    }

    @Override
    public List<Student> getByMajor(String major) {
        return studentRepository.getByMajor(major);
    }

    @Override
    public List<Course> getCourseByStudentId(Long id) {
        var courseIds = studentRepository.getCoursesByStudentId(id);
        return courseIds.stream()
                .map(courseRepository::getById)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }


}
