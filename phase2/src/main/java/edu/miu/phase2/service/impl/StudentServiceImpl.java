package edu.miu.phase2.service.impl;


import edu.miu.phase2.dto.CourseDto;
import edu.miu.phase2.dto.StudentDto;
import edu.miu.phase2.entity.Course;
import edu.miu.phase2.entity.Student;
import edu.miu.phase2.repository.StudentRepository;
import edu.miu.phase2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
// Not for me: With Lombok, it's possible to generate a constructor for either all class's fields (with @AllArgsConstructor)
// or all final class's fields (with @RequiredArgsConstructor).
// Moreover, if you still need an empty constructor, you can append an additional @NoArgsConstructor annotation.
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public void save(StudentDto student) {
        studentRepository.save(new Student(student.getId(), student.getFirstName(), student.getLastName(), student.getEMail(), student.getMajor()));
    }

    @Override
    public void update(StudentDto student, int id) {
        studentRepository.update(new Student(student.getId(), student.getFirstName(), student.getLastName(), student.getEMail(), student.getMajor()), id);
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(id);
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> new StudentDto(student.getId(),student.getFirstName(),student.getLastName(),student.getEMail(),student.getMajor(),student.getCoursesTaken().stream().map(course -> new CourseDto(course.getId(),course.getName(),course.getCode()))
                        .collect(Collectors.toList()))).toList();
    }

    @Override
    public StudentDto getById(int id) {
       Student student = studentRepository.findById(id);
        return new StudentDto(student.getId(),student.getFirstName(),student.getLastName(),student.getEMail(),student.getMajor(),student.getCoursesTaken().stream().map(course -> new CourseDto(course.getId(),course.getName(),course.getCode())).collect(Collectors.toList()));
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
       List<Student> students = studentRepository.findStudentsByMajor(major);
        return students.stream()
                .map(student -> new StudentDto(student.getId(),student.getFirstName(),student.getLastName(),student.getEMail(),student.getMajor(),student.getCoursesTaken().stream().map(course -> new CourseDto(course.getId(),course.getName(),course.getCode()))
                        .collect(Collectors.toList()))).toList();
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
        List<Course> courses = studentRepository.findById(studentId).getCoursesTaken();
        return courses.stream()
                .map(course -> new CourseDto(course.getId(), course.getName(), course.getCode()))
                .collect(Collectors.toList()).stream().toList();
    }
}
