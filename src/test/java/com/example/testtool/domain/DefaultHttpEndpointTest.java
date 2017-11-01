package com.example.testtool.domain;

import org.junit.Test;

public class DefaultHttpEndpointTest {

	@Test
	public void testPut() throws Exception {
		HttpEndpoint http = new DefaultHttpEndpoint();
		
		http.put("http://localhost:8080/manager/text/deploy?path=/sample");
	}
	
}
