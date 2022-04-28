package com.vkarki.labone.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Course {
    private int id;
    private String name;
    private String code;
    private boolean deleted;
}
