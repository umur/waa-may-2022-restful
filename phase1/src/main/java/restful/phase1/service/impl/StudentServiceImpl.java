package restful.phase1.service.impl;

import org.springframework.stereotype.Service;
import restful.phase1.domain.Course;
import restful.phase1.domain.Student;
import restful.phase1.dto.CourseDTO;
import restful.phase1.repository.StudentRepo;
import restful.phase1.service.StudentService;
import restful.phase1.dto.StudentDTO;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    @Override
    public List<StudentDTO> getAllStudents() {
        var entityList = studentRepo.getAllStudents();
        var result = new ArrayList<StudentDTO>();
        entityList.forEach(el -> {
            StudentDTO dto = new StudentDTO();
            dto.setFirstName(el.getFirstName());
            dto.setLastName(el.getLastName());
            dto.setCoursesTaken(el.getCoursesTaken());
            result.add(dto);
        });
        return result;
    }

    @Override
    public void save(StudentDTO s) {
        Student stu = new Student();
        stu.setFirstName(s.getFirstName());
        stu.setLastName(s.getLastName());
        stu.setCoursesTaken(s.getCoursesTaken());
        studentRepo.save(stu);
    }

    @Override
    public void delete(int id) {
        studentRepo.delete(id);
    }

    @Override
    public StudentDTO getById(int id) {
        StudentDTO stu = new StudentDTO();
        stu.setFirstName(studentRepo.getById(id).getFirstName());
        stu.setLastName(studentRepo.getById(id).getLastName());
        stu.setCoursesTaken(studentRepo.getById(id).getCoursesTaken());
        return stu;
    }

    @Override
    public StudentDTO getByFirstName(String fname) {
        StudentDTO stu = new StudentDTO();
        stu.setFirstName(studentRepo.getByFirstName(fname).getFirstName());
        stu.setLastName(studentRepo.getByFirstName(fname).getLastName());
        stu.setCoursesTaken(studentRepo.getByFirstName(fname).getCoursesTaken());
        return stu;
        //return studentRepo.getByFirstName(fname);
    }

    @Override
    public List<StudentDTO> getStudentsByMajor(String major) {
        var entityList = studentRepo.getAllStudents();
        var result = new ArrayList<StudentDTO>();
        entityList
                .stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList())
                .forEach(el -> {
            StudentDTO dto = new StudentDTO();
            dto.setFirstName(el.getFirstName());
            dto.setLastName(el.getLastName());
            dto.setCoursesTaken(el.getCoursesTaken());
            result.add(dto);
        });
        return result;

    }

    @Override
    public List<String> getCoursesByStudentId(int id) {
        return studentRepo.getCoursesByStudentId(id);
    }
}
