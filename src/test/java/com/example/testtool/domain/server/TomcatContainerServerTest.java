package com.example.testtool.domain.server;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import com.example.testtool.domain.configuration.Configuration;
import com.example.testtool.domain.deployable.DeployableArtifact;
import com.example.testtool.domain.deployable.impl.FileArtifact;
import com.example.testtool.domain.server.impl.TomcatContainerServer;

public class TomcatContainerServerTest {

	@Test
	public void testDeploy() throws Exception {
		ClassPathResource classPathResource = new ClassPathResource("sample.war");
		
		ContainerServer server = new TomcatContainerServer("http://localhost:8080", "tomcat", "s3cret".toCharArray());
		DeployableArtifact artifact = new FileArtifact(classPathResource.getFile().getAbsolutePath());
		Configuration config = null;
		server.deploy(artifact , config);
	}

}
