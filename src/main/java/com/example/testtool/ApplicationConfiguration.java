package com.example.testtool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.testtool.domain.DeployUtilInternalApplication;
import com.example.testtool.domain.configuration.FileConfiguration;
import com.example.testtool.domain.configuration.ToolConfiguration;
import com.example.testtool.domain.deployable.DeployableArtifact;
import com.example.testtool.domain.deployable.impl.FileArtifact;

@Configuration
public class ApplicationConfiguration {

	@Value("${artifact}")
	private String artifactName;

	@Value("${spring.config.location}")
	private String configFile;

	@Bean
	public DeployUtilInternalApplication application() {
		ToolConfiguration config = new FileConfiguration(configFile);
		DeployableArtifact artifact = new FileArtifact(artifactName);
		return new DeployUtilInternalApplication(config, artifact);
	}
	

}
