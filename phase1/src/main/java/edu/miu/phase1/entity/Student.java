package edu.miu.phase1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int Id;
    private String firsName;
    private String lastName;
    private String eMail;
    private String major;
    private List<Course> courseTaken;



}
