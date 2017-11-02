package com.example.testtool.domain;

import java.io.InputStream;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

public class DefaultHttpEndpointTest {

	@Test
	public void testPut() throws Exception {
		HttpEndpoint http = new DefaultHttpEndpoint();
		
		ClassPathResource classPathResource = new ClassPathResource("sample.war");

		InputStream inputStream = classPathResource.getInputStream();
		
		http.put(
				"http://localhost:8080/manager/text/deploy?path=/sample",
				"tomcat",
				"s3cret".toCharArray(),
				inputStream
		     );
		
		// no exception means everyting is OK
	}
	
}
