package restful.phase1.repository;

import org.springframework.stereotype.Repository;
import restful.phase1.domain.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {

    public static ArrayList<Course> courses;

    static{
        courses = new ArrayList<>();
        var c = new Course();
        c.setId(1);
        c.setName("FPP");
        c.setCode(390);
        courses.add(c);
    }


    public List<Course> getAllCourses(){
        return courses;
    }

    public Course getById(int id){
        return courses
                .stream()
                .filter(crs -> crs.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Course c){
        var notIncluded = courses
                .stream()
                .noneMatch(crs -> crs.getId() == c.getId());
        if(notIncluded) {
            courses.add(c);
        }
    }

    public void delete(int id){

//        //courses.remove(courses.stream().filter(crs -> crs.getId() == id));
//        Optional<Course> course = courses.stream().filter(crs-> crs.getId() == id).findFirst();
//        courses.remove(course.orElse(null));
        var temp = courses.stream().anyMatch(crs -> crs.getId() == id);
        if(temp){
            //System.out.println(courses.indexOf(courses.stream().filter(crs -> crs.getId() == id).findFirst()));
            courses.remove(courses.stream().filter(crs -> crs.getId() == id).findFirst().get());
        }
        else System.out.println("Course not found");

    }
}
