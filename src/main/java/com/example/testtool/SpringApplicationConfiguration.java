package com.example.testtool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.testtool.domain.deployable.DeployableArtifact;
import com.example.testtool.domain.deployable.impl.FileArtifact;

@Configuration
public class SpringApplicationConfiguration {

	@Value("${artifact}")
	private String artifactName;

	@Bean
	public DeployableArtifact artifact() {
		return new FileArtifact(artifactName);
	}

}
