package com.pprajapati.server.dto;

import com.pprajapati.server.domain.Course;

public class CourseDto {
   private String name;
   private String code;

   public CourseDto(){}

    public CourseDto(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
