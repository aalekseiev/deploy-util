package com.example.testtool.domain.server;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import com.example.testtool.domain.deployable.DeployableArtifact;
import com.example.testtool.domain.deployable.impl.FileArtifact;
import com.example.testtool.domain.server.impl.TomcatContainerServer;

public class TomcatContainerServerTest {

	@Test
	public void testDeploy() throws Exception {
		ClassPathResource classPathResource = new ClassPathResource("sample.war");
		
		ContainerServer server = new TomcatContainerServer("http://localhost:8080", "tomcat", "s3cret".toCharArray());
		DeployableArtifact artifact = new FileArtifact(classPathResource.getFile().getAbsolutePath());
		server.deploy(artifact);
	}
	
	@Test
	public void testStatus() throws Exception {
		ClassPathResource classPathResource = new ClassPathResource("sample.war");
		
		ContainerServer server = new TomcatContainerServer("http://localhost:8080", "tomcat", "s3cret".toCharArray());
		DeployableArtifact artifact = new FileArtifact(classPathResource.getFile().getAbsolutePath());
		server.deploy(artifact);
		String status = server.status(artifact.id());
		System.out.println("Status: " + status);
	}
	
	@Test
	public void testUndeploy() throws Exception {
		ClassPathResource classPathResource = new ClassPathResource("sample.war");
		
		ContainerServer server = new TomcatContainerServer("http://localhost:8080", "tomcat", "s3cret".toCharArray());
		DeployableArtifact artifact = new FileArtifact(classPathResource.getFile().getAbsolutePath());
		server.deploy(artifact);
		server.stop(artifact.id());
		server.start(artifact.id());
		server.undeploy(artifact.id());
	}

}
