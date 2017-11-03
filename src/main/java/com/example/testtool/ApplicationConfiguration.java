package com.example.testtool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

import com.example.testtool.domain.Application;
import com.example.testtool.domain.configuration.FileConfiguration;
import com.example.testtool.domain.configuration.ToolConfiguration;
import com.example.testtool.domain.deployable.DeployableArtifact;
import com.example.testtool.domain.deployable.impl.FileArtifact;

@Configuration
public class ApplicationConfiguration {

	@Value("${myutil.username}")
	private String username;

	@Value("${myutil.artifact}")
	private String artifactName;

	@Value("${spring.config.location}")
	private String configFile;

	@Autowired
	private ConfigurableEnvironment env;

	@Bean
	public Application app() {
		com.example.testtool.domain.configuration.ToolConfiguration config = new FileConfiguration(configFile);
		DeployableArtifact artifact = new FileArtifact(artifactName);
		System.out.println("!!!!!!!!!!!!!! creating application with !!!!!!!!!!!!!!!!!");
		System.out.println("username: " + username);
		System.out.println("artifactname: " + artifactName);
		System.out.println("config: " + configFile);
		return new Application(config, artifact);
	}

	@Bean
	public ToolConfiguration config() {
		if (!configFile.isEmpty()) {
			return new FileConfiguration(configFile);
		} else {
			return null;
		}
	}

}
