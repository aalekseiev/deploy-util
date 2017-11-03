package com.example.testtool;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.testtool.domain.DeployUtilInternalApplication;
import com.example.testtool.domain.server.ContainerServer;

@SpringBootApplication
public class DeployUtilApplication {
	
	@Autowired
	private DeployUtilInternalApplication app;
	
	@Autowired
	private ContainerServer server;
	
//
//	@Value("${username}")
//	private String username;
//	
//	@Value("${password}")
//	private String password;
	
	@Value("${command}")
	private String command;
	
	public static void main(String[] args) {
		System.out.println("APPLICATION ARGUMENTS: " + Arrays.toString(args));
						
		SpringApplication.run(DeployUtilApplication.class, args);
	}
	
	@Bean
	CommandLineRunner cmdrunner() {
		return args -> {
			System.out.println("Lalalaa trantata: " + app.toString());
			System.out.println("Going to run command: " + command);
			app.deploy(server);
		};
	}
}
