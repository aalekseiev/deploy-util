package com.example.testtool;

import java.io.IOException;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
@Order(-100)
public class YamlFileApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		Resource resource = new FileSystemResource("/home/kseniia/workspace_test/deploy_util/src/test/resources/config.yml"); //applicationContext.getResource("classpath:file.yml");
        YamlPropertySourceLoader sourceLoader = new YamlPropertySourceLoader();
		
        PropertySource<?> yamlTestProperties;
		try {
			yamlTestProperties = sourceLoader.load("yamlTestProperties", resource, null);
			applicationContext.getEnvironment().getPropertySources().addFirst(yamlTestProperties);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load yaml properties", e);
		}
        
	}

}
