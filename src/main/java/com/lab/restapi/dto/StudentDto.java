package com.lab.restapi.dto;

import lombok.Data;

@Data
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String major;
}
