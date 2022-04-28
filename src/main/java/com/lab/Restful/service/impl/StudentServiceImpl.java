package com.lab.Restful.service.impl;

import com.lab.Restful.dto.StudentDto;
import com.lab.Restful.entity.Course;
import com.lab.Restful.entity.Student;
import com.lab.Restful.repo.StudentRepo;
import com.lab.Restful.service.CourseService;
import com.lab.Restful.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final CourseService courseService;


    @Override
    public void save(Student s) {
        Student st=new Student();
        st.setId(s.getId());
        st.setFirstName(s.getFirstName());
        st.setLastName(s.getLastName());
        st.setEmail(s.getEmail());
        st.setMajor(s.getMajor());
        studentRepo.save(st);
    }

    @Override
    public void update(Student s, int id){
        Student st= studentRepo.findById(id);
        st.setId(st.getId());//id cannot change**
        st.setFirstName(s.getFirstName());
        st.setLastName(s.getLastName());
        st.setEmail(s.getEmail());
        st.setMajor(s.getMajor());
        studentRepo.save(st);
    }

    @Override
    public void delete(int id) {
        studentRepo.deleteById(id);
    }

    @Override
    public List<StudentDto> getAll() {
        var entityList=  studentRepo.findAll();

        var result = new ArrayList<StudentDto>();
        for(Student s: entityList){
            StudentDto dto = new StudentDto();
            dto.setFirstName(s.getFirstName());
            dto.setLastName(s.getLastName());
            dto.setMajor(s.getMajor());
            result.add(dto);
        }
        return result;
        //return studentRepo.findAll();
    }

    @Override
    public StudentDto getById(int id) {

        Student s= studentRepo.findById(id);
        StudentDto dto = new StudentDto();
        dto.setFirstName(s.getFirstName());
        dto.setLastName(s.getLastName());
        dto.setMajor(s.getMajor());
        return dto;
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major){
        var entityList=  studentRepo.findAllByMajor(major);

        var result = new ArrayList<StudentDto>();
        for(Student s: entityList){
            StudentDto dto = new StudentDto();
            dto.setFirstName(s.getFirstName());
            dto.setLastName(s.getLastName());
            dto.setMajor(s.getMajor());
            result.add(dto);
        }
        return result;
        //return studentRepo.findAllByMajor(major);
    }
    @Override
    public void addClassById(int studentId, int courseId){
        Course c=courseService.getCourseById(courseId);
        Student st= studentRepo.findById(studentId);
        st.getCoursesTaken().add(c);
        studentRepo.save(st);

    }
    @Override
    public List<Course> getCoursesById(int id){
        return studentRepo.findById(id).getCoursesTaken();
    }
}
