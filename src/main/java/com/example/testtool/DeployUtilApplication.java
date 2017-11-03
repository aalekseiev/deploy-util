package com.example.testtool;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DeployUtilApplication {
	
	public static void main(String[] args) {
		System.out.println("APPLICATION ARGUMENTS: " + Arrays.toString(args));
						
		SpringApplication.run(DeployUtilApplication.class, args);
	}
}
