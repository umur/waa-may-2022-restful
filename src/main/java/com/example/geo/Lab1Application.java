package com.example.geo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab1Application {
	@Bean
	public ModelMapper getModelMapper()
	{
		try {
			return new ModelMapper();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);
	}

}
