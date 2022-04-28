package com.waa.phase1.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Long id;
    private String name;
    private String code;

    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
