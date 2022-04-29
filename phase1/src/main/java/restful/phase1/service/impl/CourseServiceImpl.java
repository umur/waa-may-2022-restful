package restful.phase1.service.impl;

import org.springframework.stereotype.Service;
import restful.phase1.domain.Course;
import restful.phase1.dto.CourseDTO;
import restful.phase1.repository.CourseRepo;
import restful.phase1.service.CourseService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public List<CourseDTO> getAllCourses(){
        var entityList = courseRepo.getAllCourses();
        var result = new ArrayList<CourseDTO>();
        entityList.forEach(el -> {
            CourseDTO dto = new CourseDTO();
            dto.setName(el.getName());
            result.add(dto);
        });
        return result;
    }


    @Override
    public void save(CourseDTO c){
        Course crs = new Course();
        crs.setName(c.getName());
        courseRepo.save(crs);
    }


    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }

    @Override
    public CourseDTO getById(int id) {
        CourseDTO dto = new CourseDTO();
        dto.setName(courseRepo.getById(id).getName());
        return dto;
    }


}
