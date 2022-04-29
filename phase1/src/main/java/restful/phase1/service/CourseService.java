package restful.phase1.service;

import restful.phase1.domain.Course;
import restful.phase1.dto.CourseDTO;
import restful.phase1.repository.CourseRepo;

import java.util.List;

public interface CourseService {

    List<CourseDTO> getAllCourses();

    void save(CourseDTO c);

    void delete(int id);

    CourseDTO getById(int id);
}
