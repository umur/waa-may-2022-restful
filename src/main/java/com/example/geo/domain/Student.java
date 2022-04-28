package com.example.geo.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
   private int id;
   private String firstName;
   private String lastName;
   private String email;
   private String major;
   List<Course> coursesTaken;
   private double gpa;
}
