package com.example.testtool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.testtool.domain.Application;
import com.example.testtool.domain.configuration.FileConfiguration;
import com.example.testtool.domain.deployable.DeployableArtifact;
import com.example.testtool.domain.deployable.impl.FileArtifact;

@Configuration
public class ApplicationConfiguration {

	@Value("${username}")
	private String username;

	@Value("${artifact}")
	private String artifactName;

	@Value("${config}")
	private String configFilename;

	@Bean
	public Application app() {
		com.example.testtool.domain.configuration.Configuration config = new FileConfiguration(configFilename);
		DeployableArtifact artifact = new FileArtifact(artifactName);
		return new Application(config, artifact);
	}

}
