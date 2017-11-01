package com.example.testtool.domain;

import com.example.testtool.domain.configuration.Configuration;
import com.example.testtool.domain.deployable.DeployableArtifact;
import com.example.testtool.domain.server.ContainerServer;

public final class Application {

	private final Configuration config;

	private final DeployableArtifact artifact;

	public Application(Configuration config, DeployableArtifact artifact) {
		super();
		this.config = config;
		this.artifact = artifact;
	}

	public void deploy(ContainerServer server) {
		server.deploy(artifact, config);
	}
}
