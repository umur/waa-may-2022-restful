package restful.phase1.domain;

import lombok.*;

import java.util.List;

@Data
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<String> coursesTaken;
    private float gpa;
}
