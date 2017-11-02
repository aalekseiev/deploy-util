package com.example.testtool;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeployUtilApplication {
	
	public static void main(String[] args) {
		System.out.println("APPLICATION ARGUMENTS: " + Arrays.toString(args));
		SpringApplication.run(DeployUtilApplication.class, args);
	}
}
