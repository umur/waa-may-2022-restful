package restful.phase1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restful.phase1.domain.Student;
import restful.phase1.service.StudentService;

import java.util.List;

@RestController
//@RequestMapping("/api/v1/student")
public class StudentController {

        private final StudentService studentService;

    public StudentController(StudentService studentService) {
            this.studentService = studentService;
        }
        @PostMapping(value = "/api/v1/student")
        public void save (@RequestBody Student s){
            studentService.save(s);
        }

        @DeleteMapping("/api/v1/student/{id}")
        public void delete ( @PathVariable int id){
            studentService.delete(id);
        }

        @GetMapping("/api/v1/student/{id}")
        public ResponseEntity<Student> getById ( @PathVariable int id){
            return ResponseEntity.ok(studentService.getById(id));
        }

        @GetMapping("/api/v1/student")
        public List<Student> getAllStudents () {
            return studentService.getAllStudents();
        }


    @GetMapping(value = "/api/v2/student/{id}")
    public List<String>  getCoursesByStudentId(@PathVariable int id){
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping(value = "/api/v2/student/byMajor/{major}")
    public List<Student>  getStudentByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

}
