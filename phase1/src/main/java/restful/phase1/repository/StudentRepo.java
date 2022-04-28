package restful.phase1.repository;

import org.springframework.stereotype.Repository;
import restful.phase1.domain.Course;
import restful.phase1.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {

    public static ArrayList<Student> students;

    static{
        students = new ArrayList<>();
        var stu = new Student();
        stu.setId(1);
        stu.setFirstName("John");
        stu.setLastName("Smith");
        stu.setEmail("john@miu.edu");
        stu.setMajor("CS");
        stu.setCoursesTaken(new ArrayList<String>(List.of("FPP", "MPP", "WAA")));
        stu.setGpa(3.9f);

        students.add(stu);
    }

    public List<Student> getStudentsByMajor(String major){
        var list= students
                .stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
        if(!list.isEmpty()) return list;
        else return null;
    }

    public List<String> getCoursesByStudentId(int id){
        var stu= students
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
        if(stu !=null ) return stu.getCoursesTaken();
        else return null;

    }

    public List<Student> getAllStudents(){
        return students;
    }

    public Student getById(int id){
        return students
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Student getByFirstName(String fname){
        return students
                .stream()
                .filter(s -> s.getFirstName().equals(fname))
                .findFirst()
                .orElse(null);
    }

    public void save(Student stu){
        var notIncluded = students
                .stream()
                .noneMatch(s -> s.getId() == stu.getId());
        if(notIncluded) {
            students.add(stu);
        }
    }

    public void delete(int id){
        var isPresent = students.stream().anyMatch(s -> s.getId() == id);
        if(isPresent){
            students.remove(students.stream().filter(s -> s.getId() == id).findFirst().get());
        }
        else System.out.println("Student not found");
    }





}
