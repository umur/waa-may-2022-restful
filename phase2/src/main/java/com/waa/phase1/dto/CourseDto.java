package com.waa.phase1.dto;

import com.waa.phase1.domain.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
    private Long id;
    private String name;
    private String code;

    public CourseDto(Course c) {
        this.setId(c.getId());
        this.setName(c.getName());
        this.setCode(c.getCode());
    }

    public Course toCourse() {
        Course c = new Course();
        c.setId(getId());
        c.setName(getName());
        c.setCode(getCode());
        return c;
    }
}
