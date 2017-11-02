package com.example.testtool;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.FileSystemResource;

//@Configuration
//@Order(-100)
public class PropertiesConfiguration {

//	@Value("${config}")
	private String configFile = "/home/kseniia/workspace_test/deploy-util/src/test/resources/config.yml";

	
//	@Bean
	public PropertyPlaceholderConfigurer placeHolderConfigurer() throws IOException {
		PropertyPlaceholderConfigurer props = new PropertyPlaceholderConfigurer();
		props.setSystemPropertiesMode(PropertyPlaceholderConfigurer.SYSTEM_PROPERTIES_MODE_OVERRIDE);
		props.setLocations(new FileSystemResource("/home/kseniia/workspace_test/deploy-util/src/test/resources/config.yml"));
		return props;
	}
}
