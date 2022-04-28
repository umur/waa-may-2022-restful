package restful.phase1.service;

import restful.phase1.domain.Course;
import restful.phase1.repository.CourseRepo;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    void save(Course c);

    void delete(int id);

    Course getById(int id);
}
