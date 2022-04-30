package edu.miu.phase2.dto;

import edu.miu.phase2.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String major;
    private List<CourseDto> coursesTaken;

}
