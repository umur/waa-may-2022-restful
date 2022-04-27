package com.example.lab1;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.IntStream;

@SpringBootApplication
public class Lab1Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab1Application.class, args);
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    public int findDuplicate(int[] nums) {
        int dup = 0;
        for(Integer i: nums)
            dup ^= i;
        return dup ^ IntStream.rangeClosed(1, nums.length)
                .reduce(1,(x,y)  -> x^=y);

    }
}
