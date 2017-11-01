package com.example.testtool.domain.server;

import com.example.testtool.domain.configuration.Configuration;
import com.example.testtool.domain.deployable.DeployableArtifact;

public interface ContainerServer {

	void deploy(DeployableArtifact artifact, Configuration config);
	
}
