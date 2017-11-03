package com.example.testtool.domain;

import com.example.testtool.domain.configuration.ToolConfiguration;
import com.example.testtool.domain.deployable.DeployableArtifact;
import com.example.testtool.domain.server.ContainerServer;

public class DeployUtilInternalApplication {

	private final ToolConfiguration config;

	private final DeployableArtifact artifact;

	public DeployUtilInternalApplication(
			   ToolConfiguration config,
               DeployableArtifact artifact/*,
               String command*/
           ) {
		super();
		this.config = config;
		this.artifact = artifact;
	}

	public void deploy(ContainerServer server) throws Exception {
		server.deploy(artifact, config);
	}
}
