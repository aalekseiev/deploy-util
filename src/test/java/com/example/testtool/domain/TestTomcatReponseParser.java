package com.example.testtool.domain;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import com.example.testtool.domain.deployable.impl.FileArtifactId;
import com.example.testtool.domain.server.impl.TomcatResponseParser;

public class TestTomcatReponseParser {

	@Test
	public void testParseListApplications() throws IOException {
		ClassPathResource res = new ClassPathResource("apps_list.txt");
		String appsListResponse = IOUtils.toString(res.getInputStream(), StandardCharsets.UTF_8.name());
		
		TomcatResponseParser parser = new TomcatResponseParser(appsListResponse);
		String line = parser.applicationLine(new FileArtifactId("sample"));
		System.out.println("Sample application: " + line);
	}
	
}
