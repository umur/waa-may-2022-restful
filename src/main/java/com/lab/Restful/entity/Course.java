package com.lab.Restful.entity;
import lombok.Data;
import javax.persistence.*;

//id, name, code.
@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String code;
    /*
    @ManyToOne
    @JoinColumn(name = "id")
    private Student student;
    */
}
