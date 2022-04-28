package com.lab.Restful.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

//id, firstName, lastName, email, major, and coursesTaken.
//A student can take multiple courses.
@Entity
@Data
public class Student {


    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;//does it use
    private String firstName;
    private String lastName;
    private String email;
    private String major;

    @ManyToMany
    private List<Course> coursesTaken;

}
