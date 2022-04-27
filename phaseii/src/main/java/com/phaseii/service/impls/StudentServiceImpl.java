package com.phaseii.service.impls;

import com.phaseii.domain.Course;
import com.phaseii.domain.Student;
import com.phaseii.dto.CourseDto;
import com.phaseii.dto.StudentDto;
import com.phaseii.repository.StudentRepository;
import com.phaseii.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> findAll() {
        var students =  studentRepository.findAll();
        return students.stream().map(student -> new StudentDto(student.getId(),student.getFirstName(),student.getLastName(),student.getEmail(),student.getMajor(),student.getGpa(),student.getCoursesTaken())).toList();
    }

    @Override
    public StudentDto findById(Long id) {
        var student =  studentRepository.findById(id);
        return new StudentDto(student.getId(),student.getFirstName(),student.getLastName(),student.getEmail(),student.getMajor(),student.getGpa(),student.getCoursesTaken());
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        var student =  studentRepository.save(new Student(studentDto.getId(), studentDto.getFirstName(),studentDto.getLastName(),studentDto.getEmail(),studentDto.getMajor(),studentDto.getGpa(),studentDto.getCoursesTaken()));
        return new StudentDto(student.getId(),student.getFirstName(),student.getLastName(),student.getEmail(),student.getMajor(),student.getGpa(),student.getCoursesTaken());
    }

    @Override
    public StudentDto update(StudentDto studentDto, Long id) {
        var student =  studentRepository.update(new Student(studentDto.getId(), studentDto.getFirstName(),studentDto.getLastName(),studentDto.getEmail(),studentDto.getMajor(),studentDto.getGpa(),studentDto.getCoursesTaken()),id);
        return new StudentDto(student.getId(),student.getFirstName(),student.getLastName(),student.getEmail(),student.getMajor(),student.getGpa(),student.getCoursesTaken());
    }

    @Override
    public void remove(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getMajor().equals(major))
                .map(student -> new StudentDto(student.getId(),student.getFirstName(),student.getLastName(),student.getEmail(),student.getMajor(),student.getGpa(),student.getCoursesTaken()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(Long studentId) {
        var courses =  studentRepository.findById(studentId).getCoursesTaken();
        return courses.stream().map(course -> new CourseDto(course.getId(),course.getName(),course.getCode())).collect(Collectors.toList());
    }
}
