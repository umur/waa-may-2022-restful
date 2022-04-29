package restful.phase1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restful.phase1.domain.Student;
import restful.phase1.dto.StudentDTO;
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
        public void save (@RequestBody StudentDTO s){
            studentService.save(s);
        }

        @DeleteMapping("/api/v1/student/{id}")
        public void delete ( @PathVariable int id){
            studentService.delete(id);
        }

        @GetMapping("/api/v1/student/{id}")
        public ResponseEntity<StudentDTO> getById ( @PathVariable int id){
            return ResponseEntity.ok(studentService.getById(id));
        }

        @GetMapping("/api/v1/student")
        public List<StudentDTO> getAllStudents () {
            return studentService.getAllStudents();
        }


    @GetMapping(value = "/api/v2/student/{id}")
    public List<String>  getCoursesByStudentId(@PathVariable int id){
        return studentService.getCoursesByStudentId(id);
    }

    @GetMapping(value = "/api/v2/student/byMajor/{major}")
    public List<StudentDTO>  getStudentByMajor(@PathVariable String major){
        return studentService.getStudentsByMajor(major);
    }

}
