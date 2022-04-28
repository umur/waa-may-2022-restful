package com.lab.restapi.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String code;

}
