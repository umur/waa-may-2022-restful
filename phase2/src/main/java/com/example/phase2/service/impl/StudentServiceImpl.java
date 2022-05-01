package com.example.phase2.service.impl;

import com.example.phase2.domain.Course;
import com.example.phase2.domain.Student;
import com.example.phase2.dto.CourseDto;
import com.example.phase2.dto.StudentDto;
import com.example.phase2.repository.StudentRepo;
import com.example.phase2.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    private StudentServiceImpl(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }
    @Override
    public List<StudentDto> getAll() {
        var entityList= studentRepo.getAll();

        var result = new ArrayList<StudentDto>();

        entityList.forEach(s->{
            StudentDto sDto = new StudentDto();
            sDto.setFirstName(s.getFirstName());
            sDto.setLastName(s.getLastName());
            sDto.setEmail(s.getEmail());
            sDto.setMajor(s.getMajor());


            var courseDtoList = new ArrayList<CourseDto>();
            s.getCoursesTaken().forEach(course -> {

                CourseDto courseDto = new CourseDto();
                // todos..
                courseDto.setName(course.getName());
                courseDto.setCode(course.getCode());

                courseDtoList.add(courseDto);
            });
            sDto.setCoursesTaken(courseDtoList);

            result.add(sDto);
        });

        return  result;


    }

    @Override
    public void save(StudentDto sDto) {
        Random rand = new Random();

        Student s = new Student();
        s.setId(rand.nextInt());
        s.setFirstName(sDto.getFirstName());
        s.setLastName(sDto.getLastName());
        s.setEmail(sDto.getEmail());
        s.setMajor(sDto.getMajor());

        var courseList = new ArrayList<Course>();

        final int[] cntr = {1};
        sDto.getCoursesTaken().forEach(cDto->{
            Course c = new Course();

            c.setId(cntr[0]);
            c.setName(cDto.getName());
            c.setCode(cDto.getName());

            courseList.add(c);

            cntr[0] = cntr[0] +1;
        });

        s.setCoursesTaken(courseList);

        studentRepo.save(s);
    }
}
