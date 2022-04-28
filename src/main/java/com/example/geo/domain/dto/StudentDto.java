package com.example.geo.domain.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {
   private int id;
   private String firstName;
   private String lastName;
   private String email;
   private String major;
   List<CourseDto> coursesTaken;
   private double gpa;
}
