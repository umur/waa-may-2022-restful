package restful.phase1.service.impl;

import org.springframework.stereotype.Service;
import restful.phase1.domain.Course;
import restful.phase1.repository.CourseRepo;
import restful.phase1.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public List<Course> getAllCourses(){
        return courseRepo.getAllCourses();
    }

    @Override
    public void save(Course c){
        courseRepo.save(c);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }

    @Override
    public Course getById(int id) {
        return courseRepo.getById(id);
    }


}
