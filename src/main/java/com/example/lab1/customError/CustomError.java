package com.example.lab1.customError;

import lombok.Data;

@Data
public class CustomError {
    private final String message;
    public CustomError(String message){
        this.message = message;
    }
}
