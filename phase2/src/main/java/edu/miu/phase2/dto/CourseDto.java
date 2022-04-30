package edu.miu.phase2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseDto {
    private int Id;
    private String name;
    private String code;
}
