package com.example.testtool;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.test.context.TestPropertySource;

import com.example.testtool.domain.Application;
import com.example.testtool.domain.configuration.FileConfiguration;
import com.example.testtool.domain.configuration.ToolConfiguration;
import com.example.testtool.domain.deployable.DeployableArtifact;
import com.example.testtool.domain.deployable.impl.FileArtifact;

@Configuration
public class ApplicationConfiguration {

	@Value("${username}")
	private String username;

	@Value("${artifact}")
	private String artifactName;

	@Value("${config}")
	private String configFile;

	@Autowired
	private ConfigurableEnvironment env;

	@Bean
	public Application app() {
		com.example.testtool.domain.configuration.ToolConfiguration config = new FileConfiguration(configFile);
		DeployableArtifact artifact = new FileArtifact(artifactName);
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
