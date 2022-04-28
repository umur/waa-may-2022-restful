package com.vkarki.labone.service.impl;

import com.vkarki.labone.domain.Course;
import com.vkarki.labone.domain.Student;
import com.vkarki.labone.dto.SimpleCourseDto;
import com.vkarki.labone.dto.SimpleStudentDto;
import com.vkarki.labone.dto.SimpleStudentDtoV2;
import com.vkarki.labone.repository.StudentRepo;
import com.vkarki.labone.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;


    @Override
    public void save(SimpleStudentDto student) {
        Student s = new Student();
        s.setFirstName(student.getFirstName());
        s.setLastName(student.getLastName());
        s.setEmail(student.getEmail());
        s.setMajor(student.getMajor());
        List<SimpleCourseDto> simpleCourseDtos = student.getCoursesTaken();
        List<Course> courses = new ArrayList<>();
        simpleCourseDtos.forEach(course -> {
            Course c = new Course();
            c.setName(course.getName());
            c.setCode(course.getCode());
            c.setId(course.getId());
            courses.add(c);
        });
        s.setCoursesTaken(courses);
        studentRepo.save(s);
    }

    @Override
    public void update(SimpleStudentDto student, int id) {
        Student s = new Student();
        s.setFirstName(student.getFirstName());
        s.setLastName(student.getLastName());
        s.setEmail(student.getEmail());
        s.setMajor(student.getMajor());
        List<SimpleCourseDto> simpleCourseDtos = student.getCoursesTaken();
        List<Course> courses = new ArrayList<>();
        simpleCourseDtos.forEach(course -> {
            Course c = new Course();
            c.setName(course.getName());
            c.setCode(course.getCode());
            c.setId(course.getId());
            courses.add(c);
        });
        s.setCoursesTaken(courses);
        studentRepo.update(s, id);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public List<SimpleStudentDto> getAll() {
        var students = studentRepo.getAll();

        var results = new ArrayList<SimpleStudentDto>();

        students.forEach(student->{
            SimpleStudentDto s = new SimpleStudentDto();
            s.setFirstName(student.getFirstName());
            s.setLastName(student.getLastName());
            s.setEmail(student.getEmail());
            s.setMajor(student.getMajor());

            List<Course> courses = student.getCoursesTaken();
            List<SimpleCourseDto> simpleCourseDtos = new ArrayList<>();
            courses.forEach(course -> {
                SimpleCourseDto c = new SimpleCourseDto();
                c.setName(course.getName());
                c.setCode(course.getCode());
                c.setId(course.getId());
                simpleCourseDtos.add(c);
            });

            s.setCoursesTaken(simpleCourseDtos);


            results.add(s);
        });

        return results;

    }


    @Override
    public List<SimpleStudentDtoV2> getAllV2() {
        var students = studentRepo.getAll();

        var results = new ArrayList<SimpleStudentDtoV2>();

        students.forEach(student->{
            SimpleStudentDtoV2 s = new SimpleStudentDtoV2();
            s.setFirstName(student.getFirstName());
            s.setLastName(student.getLastName());
            s.setEmail(student.getEmail());
            s.setMajor(student.getMajor());
            s.setGpa(student.getGpa());

            List<Course> courses = student.getCoursesTaken();
            List<SimpleCourseDto> simpleCourseDtos = new ArrayList<>();
            courses.forEach(course -> {
                SimpleCourseDto c = new SimpleCourseDto();
                c.setName(course.getName());
                c.setCode(course.getCode());
                c.setId(course.getId());
                simpleCourseDtos.add(c);
            });

            s.setCoursesTaken(simpleCourseDtos);


            results.add(s);
        });

        return results;

    }

    @Override
    public SimpleStudentDto getById(int id) {

        var student = studentRepo.getById(id);

        SimpleStudentDto s = new SimpleStudentDto();

        s.setFirstName(student.getFirstName());
        s.setLastName(student.getLastName());
        s.setEmail(student.getEmail());
        s.setMajor(student.getMajor());

        List<Course> courses = student.getCoursesTaken();
        List<SimpleCourseDto> simpleCourseDtos = new ArrayList<>();
        courses.forEach(course -> {
            SimpleCourseDto c = new SimpleCourseDto();
            c.setName(course.getName());
            c.setCode(course.getCode());
            c.setId(course.getId());
            simpleCourseDtos.add(c);
        });


        s.setCoursesTaken(simpleCourseDtos);

        return s;

    }

    @Override
    public List<SimpleStudentDtoV2> getStudentsByMajor(String major) {
        var students = studentRepo.getStudentsByMajor(major);

        var results = new ArrayList<SimpleStudentDtoV2>();

        students.forEach(student->{
            SimpleStudentDtoV2 s = new SimpleStudentDtoV2();
            s.setFirstName(student.getFirstName());
            s.setLastName(student.getLastName());
            s.setEmail(student.getEmail());
            s.setMajor(student.getMajor());
            s.setGpa(student.getGpa());

            List<Course> courses = student.getCoursesTaken();
            List<SimpleCourseDto> simpleCourseDtos = new ArrayList<>();
            courses.forEach(course -> {
                SimpleCourseDto c = new SimpleCourseDto();
                c.setName(course.getName());
                c.setCode(course.getCode());
                c.setId(course.getId());
                simpleCourseDtos.add(c);
            });

            s.setCoursesTaken(simpleCourseDtos);


            results.add(s);
        });

        return results;
    }
}
