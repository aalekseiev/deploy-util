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
	
	@Value("${command}")
	private String command;
	
	public static void main(String[] args) {
		SpringApplication.run(DeployUtilApplication.class, args);
	}
	
	@Bean
	CommandLineRunner cmdrunner() {
		return args -> {
			switch (command) {
				case "deploy":
					app.deploy(server);
					System.out.println("Successfully deployed application: " + app.name());
					break;
				case "undeploy":
					app.undeploy(server);
					System.out.println("Successfully undeployed application: " + app.name());
					break;
				case "status":
					System.out.println("Status=" + app.status(server) + " of application: " + app.name());
					break;
				case "start":
					app.start(server);
					System.out.println("Successfully started application: " + app.name());
					break;
				case "stop":
					app.stop(server);
					System.out.println("Successfully stopped application: " + app.name());
					break;
			}
			
		};
	}
}
