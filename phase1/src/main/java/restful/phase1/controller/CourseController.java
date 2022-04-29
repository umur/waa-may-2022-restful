package restful.phase1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restful.phase1.domain.Course;
import restful.phase1.dto.CourseDTO;
import restful.phase1.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public void save(@RequestBody CourseDTO c) {
        courseService.save(c);
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getById(@PathVariable int id) {
        return ResponseEntity.ok(courseService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }


}
