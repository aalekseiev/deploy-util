package com.example.testtool.domain.server;

import com.example.testtool.domain.configuration.ToolConfiguration;
import com.example.testtool.domain.deployable.ArtifactId;
import com.example.testtool.domain.deployable.DeployableArtifact;

public interface ContainerServer {

	void deploy(DeployableArtifact artifact, ToolConfiguration config) throws Exception;
	
	void undeploy(ArtifactId artifactId) throws Exception;
	
	void start(ArtifactId artifactId) throws Exception;
	
	void stop(ArtifactId artifactId) throws Exception;
		
	String status(ArtifactId artifactId) throws Exception;
	
}
